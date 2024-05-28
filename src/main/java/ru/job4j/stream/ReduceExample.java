package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        Optional<Integer> sum = numbers.stream()
                .reduce(Integer::sum);
        System.out.println(sum.get());
        List<String> nums = List.of("Один", "Два", "Три");
        Optional<String> sum2 = nums.stream()
                .reduce((left, right) -> left + ", " + right);
        System.out.println(sum2.get());

        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4);
        int sum3 = nums3.stream()
                .reduce(2, (left, right) -> left + right);
        System.out.println(sum3);

        System.out.println();

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum4 = people.stream()
                .reduce(
                        0,
                        (accumulator, right) -> {
                            if (right.getAge() > 25) {
                                return accumulator + right.getAge();
                            } else {
                                return accumulator;
                            }
                        },
                        (left, right) -> left + right
                );
        System.out.println(sum4);
    }
}