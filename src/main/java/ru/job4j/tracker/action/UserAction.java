package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Store;

import java.sql.SQLException;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker) throws SQLException;
}
