package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        return decorations.stream()
                .map(Decoration::getComfort)
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public void addFish(Fish fish) {
        if (fish.getSize() >= capacity) {
            throw new IllegalStateException("Not enough capacity.");
        }

        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        return "Fish: " + fish.stream().map(Fish::getName).reduce((f1, f2) -> f1 + " " + f2).orElse("None") + '\n' +
                "Decorations: " + decorations.size() + '\n' +
                "Comfort: " + calculateComfort();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Aquarium name cannot be null or empty.");
        }
        this.name = name;
    }
}
