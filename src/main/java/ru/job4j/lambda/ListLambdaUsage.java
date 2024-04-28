package ru.job4j.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class ListLambdaUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 7, 9, 12);

        list.forEach(s -> System.out.println("Current number: " + s));

        UnaryOperator<Integer> operator = i -> i * i;
        list.replaceAll(operator);
        System.out.println();
        list.forEach(s -> System.out.println("Current number: " + s));

        System.out.println("-----------------------");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println();

        BiFunction<Integer, String, String> function = (key, value) -> value + "_" + key;
        String result = map.computeIfPresent(1, function);

        System.out.println("Current value: " + result);

    }
}