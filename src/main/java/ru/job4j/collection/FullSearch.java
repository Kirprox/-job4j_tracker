package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public List<String> extractNumber(List<Task> tasks) {
        Set<Task> set = new HashSet<>(tasks);
        List<String> rsl = new ArrayList<>();
        for (Task task : set) {
            rsl.add(task.getNumber());
        }
        return rsl;
    }
}
