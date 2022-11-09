package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SpotRepository implements Repository<Spot> {
    private Map<String, Spot> data;

    public SpotRepository() {
        data = new HashMap<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(data.values());
    }

    @Override
    public void add(Spot entity) {
        data.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Spot entity) {
        return data.remove(entity.getName(), entity);
    }

    @Override
    public Spot byName(String name) {
        return data.get(name);
    }
}
