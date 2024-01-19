package ru.job4j.inheritance;

public class ToyCat extends Cat {

    @Override
    public boolean canPurr() {
        return super.canPurr();
    }

    public boolean canBeWashByWashMachine() {
        return true;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.canPurr());
        ToyCat toy = new ToyCat();
        System.out.println(toy.canPurr());
        System.out.println(toy.canBeWashByWashMachine());
    }
}
