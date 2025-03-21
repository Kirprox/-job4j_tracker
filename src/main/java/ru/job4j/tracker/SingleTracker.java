package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private MemTracker tracker = new MemTracker();
    private static SingleTracker instance = null;

    public SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}
