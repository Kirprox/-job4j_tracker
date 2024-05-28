package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result = strings
                .stream()
                .noneMatch("Шесть"::contains);
        System.out.println(result);
        System.out.println();
        List<String> strings2 = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result2 = strings2
                .stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(result2);
        System.out.println();
        List<String> strings3 = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result3 = strings3
                .stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(result3);
    }
}