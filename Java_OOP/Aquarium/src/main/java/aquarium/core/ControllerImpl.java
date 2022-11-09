package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        decorationRepository = new DecorationRepository();
        aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        switch (aquariumType) {
            case "SaltwaterAquarium":
                SaltwaterAquarium aquarium = new SaltwaterAquarium(aquariumName);
                aquariums.add(aquarium);
                break;
            case "FreshwaterAquarium":
                FreshwaterAquarium freshwaterAquarium = new FreshwaterAquarium(aquariumName);
                aquariums.add(freshwaterAquarium);
                break;
            default:
                throw new NullPointerException("Invalid aquarium type.");
        }

        return String.format("Successfully added %s.", aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        switch (type) {
            case "Ornament":
                Ornament ornament = new Ornament();
                decorationRepository.add(ornament);
                break;
            case "Plant":
                Plant plant = new Plant();
                decorationRepository.add(plant);
                break;
            default:
                throw new IllegalArgumentException("Invalid decoration type.");
        }

        return String.format("Successfully added %s.", type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorationRepository.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format("There isn't a decoration of type %s.", decorationType));
        }

        Aquarium aquarium = getAquariumByName(aquariumName);

        aquarium.addDecoration(decoration);

        return String.format("Successfully added %s to %s.", decorationType, aquariumName);
    }



    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = getAquariumByName(aquariumName);
        switch (fishType) {
            case "SaltwaterFish":
                SaltwaterFish saltwaterFish = new SaltwaterFish(fishName, fishSpecies, price);
                return addFish(saltwaterFish, aquarium);
            case "FreshwaterFish":
                FreshwaterFish freshwaterFish = new FreshwaterFish(fishName, fishSpecies, price);
                return addFish(freshwaterFish, aquarium);
            default:
                throw new IllegalArgumentException("Invalid fish type.");
        }
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = getAquariumByName(aquariumName);
        aquarium.feed();
        return String.format("Fish fed: %d", aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = getAquariumByName(aquariumName);
        double fishPrice = aquarium.getFish().stream()
                .mapToDouble(Fish::getPrice)
                .reduce(Double::sum)
                .orElse(0d);
        double decorationPrice = aquarium.getDecorations().stream()
                .mapToDouble(Decoration::getPrice)
                .reduce(Double::sum)
                .orElse(0d);

        return String.format("The value of Aquarium %s is %.2f.", aquariumName, fishPrice + decorationPrice);
    }

    @Override
    public String report() {
        return aquariums.stream().map(Aquarium::getInfo).collect(Collectors.joining("\n"));
    }

    private Aquarium getAquariumByName(String aquariumName) {
        return aquariums.stream()
                .filter(aq -> aq.getName().equals(aquariumName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("There isn't such aquarium."));
    }

    private String addFish(Fish fish, Aquarium aquarium) {
        try {
            aquarium.addFish(fish);
        } catch (IllegalStateException e) {
            return "Not enough capacity.";
        } catch (IllegalArgumentException e) {
            return "Water not suitable.";
        }
        return String.format("Successfully added %s to %s.", fish.getClass().getSimpleName(), aquarium.getName());
    }
}
