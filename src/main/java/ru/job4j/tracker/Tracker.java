package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            items[index].setId(id);
            return true;
        }
        return false;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int sizeResult = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                result[sizeResult] = items[i];
                sizeResult++;
            }
        }
        result = Arrays.copyOf(result, sizeResult);
        return result;
    }

    public Item[] findByName(String key) {
        int sizeResult = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[sizeResult] = items[i];
                sizeResult++;
            }
        }
        result = Arrays.copyOf(result, sizeResult);
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }
}