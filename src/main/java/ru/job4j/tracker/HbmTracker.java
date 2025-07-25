package ru.job4j.tracker;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Ошибка при добавлении заявки: {}", item, e);
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            int updated = session.createQuery(""" 
                            UPDATE Item SET name = :fName,
                                       created = :fCreated
                              WHERE id = :fId""")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id).executeUpdate();
            session.getTransaction().commit();
            result = updated > 0;
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Ошибка при изменении заявки: {}", item, e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE FROM Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("ошибка при удалении заявки с id: {}", id, e);
        } finally {
            session.close();
        }

    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> items = new ArrayList<>();
        try {
            session.beginTransaction();
            items = session.createQuery("FROM Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Ошибка при получении списка заявок: ", e);
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> items = new ArrayList<>();
        try {
            session.beginTransaction();
            items = session.createQuery("FROM Item WHERE name = :fName", Item.class)
                    .setParameter("fName", key).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Ошибка при получении заявки по имени: {}", key, e);
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item item = null;
        try {
            session.beginTransaction();
            item = session.createQuery("FROM Item WHERE id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Ошибка при получении заявки по id: {}", id, e);
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}