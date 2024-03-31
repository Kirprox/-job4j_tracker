package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result;
        int size = Math.min(o1.length(), o2.length());
        for (int i = 0; i < size; i++) {
            if (o1.charAt(i) != o2.charAt(i)) {
                return o1.charAt(i) - o2.charAt(i);
            }
        }
        result = o1.length() - o2.length();
        return result;
    }
}
