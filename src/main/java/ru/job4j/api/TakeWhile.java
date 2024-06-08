package ru.job4j.api;

import java.util.List;
import java.util.stream.Stream;

public class TakeWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).stream()
                .takeWhile(value -> value < 3)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);
        System.out.println();
        List.of(1, 2, 3, 4, 1, 2).stream()
                .dropWhile(value -> value < 3)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);
        System.out.println();
        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);
    }

}