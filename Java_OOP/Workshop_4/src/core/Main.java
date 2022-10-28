package core;

import factory.VehicleFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write which vehicle to drive");
        String line = scanner.nextLine();
        while(!line.equals("exit")) {
            Vehicle vehicle = vehicleFactory.create(line);
            vehicle.drive();
            line = scanner.nextLine();
        }


//        switch (vehicleType) {
//            case "Car":
//                System.out.println("Car is driven! Brrrm!");
//                break;
//            case "Truck":
//                System.out.println("Truck is driven!");
//                break;
//            case "Motorcycle":
//                System.out.println("Motorcycle is driven!");
//                break;
//            default:
//                System.out.println("Unidentified vehicle is driven!");
//        }
    }
}