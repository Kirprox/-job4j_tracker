package ru.job4j.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;
    private static final String NEWVALUE = "";
    private String name;
    private String surname;

    public Broken() {
    }

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d) {
    }
}
