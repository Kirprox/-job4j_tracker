package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("kirpro95@yandex.ru", "Razhin Kirill Vladimirovich");
        map.put("kirpro95@yandex.ru", "Petrov Kirill Sergeevich");
        map.put("kirprox9595@gmail.com", "Ivanov Kirill Andreevich");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
