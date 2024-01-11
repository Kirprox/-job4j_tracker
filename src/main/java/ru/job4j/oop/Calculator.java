package ru.job4j.oop;

public class Calculator {
    static private int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public int multiply(int a) {
        return x * a;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(10);
        System.out.println(result);
        result = calculator.divide(10);
        System.out.println(result);
        result = calculator.sumAllOperation(10);
        System.out.println(result);
        System.out.println(Calculator.minus(10));
        System.out.println(Calculator.sum(10));
    }
}
