package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameTest {
    @Test
    public void whenItemWasFindByNameSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        FindByName findByIdAction = new FindByName(output);
        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("new item");
        findByIdAction.execute(input, tracker);

        String formattedDate = item.getCreated()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        assertThat(output.toString()).isEqualTo(
                String.format(
                        "=== Вывод заявки по имени ===%n"
                                + "id: %d, name: %s, created: %s%n",
                        item.getId(), item.getName(), formattedDate
                )
        );
    }

}