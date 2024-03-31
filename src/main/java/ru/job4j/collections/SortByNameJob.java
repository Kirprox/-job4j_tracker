package ru.job4j.collections;

import java.util.Comparator;

public class SortByNameJob implements Comparator<Job> {

    @Override
    public int compare(Job left, Job right) {
        return left.getName().compareTo(right.getName());
    }
}
