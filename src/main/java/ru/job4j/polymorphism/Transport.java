package ru.job4j.polymorphism;

public interface Transport {
    void move();

    void passengers(int count);

    int fillFuel(int countFuel);
}
