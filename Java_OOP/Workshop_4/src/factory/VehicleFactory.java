package factory;

import core.Vehicle;
import data.*;

public class VehicleFactory {
    public Vehicle create(String vehicleType) {
        switch (vehicleType) {
            case "Car":
                return Car.createCar();
            case "Truck":
                return new Truck();
            case "Motorcycle":
                return new Motorcycle();
            default:
                return new UnidentifiedVehicle();
        }
    }
}
