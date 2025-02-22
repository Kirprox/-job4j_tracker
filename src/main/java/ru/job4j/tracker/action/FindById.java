package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.MemTracker;

public class FindById implements UserAction {
    private final Output output;

    public FindById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        output.println("=== Вывод заявки по id ===");
        int id = input.askInt("Введите id : ");
        Item item = tracker.findById(id);
        output.println(item != null ? item : "Заявка по id: " + id + " не найдена");
        return true;
    }
}
