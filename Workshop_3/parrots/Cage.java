package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>(capacity);
    }

    public void add(Parrot parrot) {
        if (data.size() + 1 <= capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        Parrot parrot = getParrotByName(name);

        return data.remove(parrot);
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = getParrotByName(name);
        return sellParrot(parrot);
    }

    private Parrot sellParrot(Parrot parrot) {
        if (parrot == null) {
            throw new IllegalArgumentException("Parrot with such name does not exist!");
        }

        parrot.setAvailable(false);
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        return data.stream()
                .filter(p -> p.getSpecies().equals(species))
                .map(p -> this.sellParrot(p))
                .collect(Collectors.toList());
    }

    public int count() {
        return data.size();
    }

    public String report() {
        return String.format("Parrots available at %s:", this.name) + data.stream()
                .filter(p -> p.isAvailable())
                .map(p -> p.toString())
                .reduce("", (a, b) -> a + '\n' + b);
    }

    //["1","2","3"]
    //["" + "1", "2", "3"]
    //["1" + "2", "3"]

    private Parrot getParrotByName(String name) {
        return data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
