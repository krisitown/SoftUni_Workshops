package aquarium.entities.aquariums;

import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;

public class FreshwaterAquarium extends BaseAquarium {
    public FreshwaterAquarium(String name) {
        super(name, 50);
    }

    @Override
    public void addFish(Fish fish) {
        if (fish instanceof FreshwaterFish) {
            super.addFish(fish);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getInfo() {
        return getName() + " (FreshwaterAquarium):\n" + super.getInfo();
    }
}
