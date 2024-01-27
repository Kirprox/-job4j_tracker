package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public int fillFuel(int countFuel) {
        int pricePerLiter = 59;
        return pricePerLiter * countFuel;
    }
}
