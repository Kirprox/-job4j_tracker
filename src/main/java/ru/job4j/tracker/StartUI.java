package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Меню:");
        for (int index = 0; index < actions.size(); index++) {
            output.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) throws SQLException {
        Log4File log = Log4File.getInstance();
        log.add("add new Item");
        log.save();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker = new SqlTracker();
        List<UserAction> actions = Arrays.asList(
                new Create(output),
                new CreateManyItems(output),
                new FindAll(output),
                new Replace(output),
                new Delete(output),
                new DeleteAllItems(output),
                new FindById(output),
                new FindByName(output),
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
