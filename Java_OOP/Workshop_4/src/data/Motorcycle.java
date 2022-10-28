package data;

import core.Vehicle;

public class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Motorcycle is driven!");
    }
}
