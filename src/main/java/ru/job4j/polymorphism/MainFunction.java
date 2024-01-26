package ru.job4j.polymorphism;

public class MainFunction implements FunctionTwo, FunctionOne {
    @Override
    public double function(double x, double y) {
        return FunctionTwo.super.function(x, y);
    }

    @Override
    public void functionMessage() {
        FunctionTwo.super.functionMessage();
    }
}
