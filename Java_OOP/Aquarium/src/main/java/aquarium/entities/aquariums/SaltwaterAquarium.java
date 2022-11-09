package aquarium.entities.aquariums;

import aquarium.entities.fish.Fish;
import aquarium.entities.fish.SaltwaterFish;

public class SaltwaterAquarium extends BaseAquarium {
    public SaltwaterAquarium(String name) {
        super(name, 25);
    }

    @Override
    public void addFish(Fish fish) {
        if (fish instanceof SaltwaterFish) {
            super.addFish(fish);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getInfo() {
        return getName() + " (SaltwaterAquarium):\n" + super.getInfo();
    }
}
