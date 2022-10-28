package data;

import core.Vehicle;
import facade.MathFacade;
import facade.MathFacadeImpl;

public class Car implements Vehicle {
    private static final Car instance = new Car();
    private final MathFacade mathFacade = new MathFacadeImpl();
    private int rnd;

    private Car() {
        this.rnd = (int)(mathFacade.random()*100);
    }

    public static Car createCar() {
        return instance;
    }

    @Override
    public void drive() {
        System.out.println("Car is driven! Brrrm! " + rnd);
    }
}
