package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = bus1;
        vehicles[1] = bus2;
        vehicles[2] = plane1;
        vehicles[3] = plane2;
        vehicles[4] = train1;
        vehicles[5] = train2;
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
