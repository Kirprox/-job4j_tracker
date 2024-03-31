package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Integer first = 20;
        Integer second = 2;
        System.out.println(first.compareTo(second));
        String petr = "Petr";
        String ivan = "Ivan";
        int resultString = petr.compareTo(ivan);
        System.out.println(resultString);
        List<Integer> list2 = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list2);
        list2.sort(Collections.reverseOrder());
        System.out.println(list2);
    }
}
