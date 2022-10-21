public class Car {
    private final String model;
    private Double fuelAmount;
    private final Double costPerKilometer;
    private Double distanceTravelled;

    public Car(String model, Double fuelAmount, Double costPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costPerKilometer = costPerKilometer;
        this.distanceTravelled = 0d;
    }

    public void drive(Double distance) {
        Double neededFuel = distance * costPerKilometer;
        try {
            this.setFuelAmount(fuelAmount - neededFuel);
            this.distanceTravelled += distance;
        } catch (IllegalArgumentException ex) {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public void setFuelAmount(Double fuelAmount) {
        if(fuelAmount < 0) {
            throw new IllegalArgumentException();
        }
        this.fuelAmount = fuelAmount;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",
                this.model, this.fuelAmount, Math.round(this.distanceTravelled));
    }

    @Override
    public int hashCode() {
        return this.model.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            return ((Car)obj).model.equals(this.model);
        }
        return false;
    }
}
