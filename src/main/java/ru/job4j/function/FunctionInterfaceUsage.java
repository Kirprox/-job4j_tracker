package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "New String For Interfache";
        System.out.println(supplier.get());
        System.out.println();

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supplier1 = () -> new HashSet<>(list);
        Set<String> strings = supplier1.get();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println("consumerNext");
        System.out.println();

        Supplier<String> supplier2 = () -> "New String For Interface";
        Consumer<String> consumer = (string) -> System.out.println(string + "l");
        consumer.accept(supplier2.get());
        System.out.println();
        Supplier<String> supplier3 = () -> "New String For Interface";
        BiConsumer<String, String> consumer3 = (first, second) ->
                System.out.println(second + first + " d " + first);
        consumer3.accept(supplier3.get(), " and Second String");
        System.out.println();
        System.out.println("predicaterNext");
        System.out.println();

        Predicate<String> predicate = string -> string.isEmpty();
        System.out.println("Cтрока пустая " + predicate.test(""));
        System.out.println("Cтрока пустая " + predicate.test("test"));
        BiPredicate<String, Integer> condition = (string, number) -> string.contains(number.toString());
        System.out.println("Строка содержит подстроку: " + condition.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + condition.test("Name", 123));
        System.out.println();
        System.out.println("functionNext");
        System.out.println();

        Function<String, Character> function = string -> string.charAt(2);
        System.out.println("Третий символ в строке: " + function.apply("first"));
        System.out.println("Третий символ в строке: " + function.apply("second"));

        BiFunction<String, Integer, String> biFunction = (string, number) -> string.concat(" ").concat(number.toString());
        System.out.println("Результат работы бифункции: " + biFunction.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunction.apply("String number", 12345));
        System.out.println();
        System.out.println("unaryNext");
        System.out.println();

        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));
        BinaryOperator<StringBuilder> builder2 = (first, second) -> first.append(" ").append(second);
        System.out.println(
                "Строка после объединения: " + builder2.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
