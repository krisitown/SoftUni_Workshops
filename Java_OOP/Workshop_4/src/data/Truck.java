package data;

import core.Vehicle;

public class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Truck is driven!");
    }
}
