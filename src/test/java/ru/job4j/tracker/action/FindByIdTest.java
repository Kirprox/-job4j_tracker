package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByIdTest {
    @Test
    public void whenItemWasFindByIdSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        FindById findByIdAction = new FindById(output);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        findByIdAction.execute(input, tracker);

        String formattedDate = item.getCreated()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        assertThat(output.toString()).isEqualTo(
                String.format(
                        "=== Вывод заявки по id ===%n"
                                + "id: %d, name: %s, created: %s%n",
                        item.getId(), item.getName(), formattedDate
                )
        );
    }
}