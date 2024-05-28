package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> result = strings
                .stream()
                .skip(2)
                .toList();
        System.out.println(result);
        List<String> result2 = strings
                .stream()
                .limit(3)
                .toList();
        System.out.println(result2);
        List<String> result3 = strings
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(result3);

        String resultFindFirst = strings
                .stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(resultFindFirst);
        String result5 = strings
                .stream()
                .skip(5)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(result5);
        String result6 = strings
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(result6);
    }
}