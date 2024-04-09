package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] firstStr = left.split("/");
        String[] secondStr = right.split("/");
        int result = secondStr[0].compareTo(firstStr[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}
