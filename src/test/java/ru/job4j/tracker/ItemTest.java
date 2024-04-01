package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    @Test
    void whenNaturalCompareByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(2, "Maria"),
                new Item(3, "Andrey"),
                new Item(4, "Vasilii"),
                new Item(5, "Anastasia"));
        List<Item> expected = Arrays.asList(
                new Item(5, "Anastasia"),
                new Item(3, "Andrey"),
                new Item(1, "Ivan"),
                new Item(2, "Maria"),
                new Item(4, "Vasilii"));
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenDescCompareByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(2, "Maria"),
                new Item(3, "Andrey"),
                new Item(4, "Vasilii"),
                new Item(5, "Anastasia"));
        List<Item> expected = Arrays.asList(
                new Item(4, "Vasilii"),
                new Item(2, "Maria"),
                new Item(1, "Ivan"),
                new Item(3, "Andrey"),
                new Item(5, "Anastasia"));
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}