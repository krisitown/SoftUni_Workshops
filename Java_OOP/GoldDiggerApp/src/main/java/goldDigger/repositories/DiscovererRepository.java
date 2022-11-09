package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.*;

public class DiscovererRepository implements Repository<Discoverer> {
    private final Map<String, Discoverer> data;

    public DiscovererRepository() {
        data = new LinkedHashMap<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(data.values());
    }

    @Override
    public void add(Discoverer entity) {
        data.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Discoverer entity) {
        return data.remove(entity.getName(), entity);
    }

    @Override
    public Discoverer byName(String name) {
        return data.get(name);
    }
}
