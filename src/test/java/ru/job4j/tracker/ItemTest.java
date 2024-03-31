package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    @Test
    void whenNaturalCompareByName() {
        Item ivan = new Item(1, "Ivan");
        Item maria = new Item(2, "Maria");
        Item andrey = new Item(3, "Andrey");
        Item vasilii = new Item(4, "Vasilii");
        Item anastasia = new Item(5, "Anastasia");
        List<Item> items = Arrays.asList(
                ivan, maria, andrey, vasilii, anastasia);
        List<Item> expected = Arrays.asList(
                anastasia, andrey, ivan, maria, vasilii);
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenDescCompareByName() {
        Item ivan = new Item(1, "Ivan");
        Item maria = new Item(2, "Maria");
        Item andrey = new Item(3, "Andrey");
        Item vasilii = new Item(4, "Vasilii");
        Item anastasia = new Item(5, "Anastasia");
        List<Item> items = Arrays.asList(
                ivan, maria, andrey, vasilii, anastasia);
        List<Item> expected = Arrays.asList(
                vasilii, maria, ivan, andrey, anastasia);
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}