package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

import java.sql.SQLException;

public class Create implements UserAction {
    private final Output output;

    public Create(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Добавить новую заявку";
    }

    @Override
    public boolean execute(Input input, Store tracker)  {
        output.println("=== Создание новой заявки ===");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        try {
            tracker.add(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        output.println("Добавленная заявка: " + item);
        return true;
    }
}
