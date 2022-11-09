package goldDigger.core;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Discoverer> discovererRepository = new DiscovererRepository();
    private Repository<Spot> spotRepository = new SpotRepository();
    private Operation operation = new OperationImpl();

    private int spotsInspected = 0;

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        try {
            Class discovererKind = Class.forName("goldDigger.models.discoverer." + kind);
            Object discoverer = discovererKind.getConstructor(String.class).newInstance(discovererName);
            discovererRepository.add((Discoverer) discoverer);
            return "Added " + kind + ": " + discovererName + ".";
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Discoverer kind doesn't exists.");
        } catch (Exception e) {
            //silence exceptions
            return null;
        }
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        SpotImpl spot = new SpotImpl(spotName);
        spot.getExhibits().addAll(List.of(exhibits));
        spotRepository.add(spot);
        return "Added spot: " + spotName + ".";
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);
        if(discoverer == null) {
            throw new IllegalArgumentException("Discoverer " + discovererName + " doesn't exist.");
        }

        discovererRepository.remove(discoverer);
        return "Discoverer " + discovererName + " has excluded!";
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discoverers = discovererRepository.getCollection().stream()
                .filter(Discoverer::canDig)
                .collect(Collectors.toList());

        if(discoverers.size() == 0) {
            throw new IllegalArgumentException("You must have at least one discoverer to inspect the spot.");
        }

        spotsInspected++;
        int discoversExcluded = discovererRepository.getCollection().size() - discoverers.size();

        Spot spot = spotRepository.byName(spotName);
        operation.startOperation(spot, discoverers);
        return "The spot " + spotName +
                " was inspected. " + discoversExcluded + " discoverers have been excluded on this operation.";
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(spotsInspected + " spots were inspected.");
        stringBuilder.append('\n');
        stringBuilder.append("Information for the discoverers:");
        stringBuilder.append('\n');

        for (Discoverer discoverer : discovererRepository.getCollection()) {
            stringBuilder.append("Name: ");
            stringBuilder.append(discoverer.getName());
            stringBuilder.append('\n');

            stringBuilder.append("Energy: ");
            stringBuilder.append(discoverer.getEnergy());
            stringBuilder.append('\n');

            stringBuilder.append("Museum exhibits: ");
            stringBuilder.append(discoverer.getMuseum().getExhibits().stream()
                    .reduce("None", (ex1, ex2) -> ex1 + ", " + ex2));
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}
