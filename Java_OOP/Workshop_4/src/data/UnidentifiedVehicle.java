package data;

import core.Vehicle;

public class UnidentifiedVehicle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Unidentified vehicle is driven!");
    }
}
