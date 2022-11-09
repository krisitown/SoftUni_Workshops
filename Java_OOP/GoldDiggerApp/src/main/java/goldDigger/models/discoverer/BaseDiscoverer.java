package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer {
    private static final double DIG_COST = 15d;
    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Discoverer name cannot be null or empty.");
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if(energy < 0) {
            throw new IllegalArgumentException("Cannot create Discoverer with negative energy.");
        }
        this.energy = energy;
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public void dig() {
        this.energy = Math.max(this.energy - DIG_COST, 0);
    }
}
