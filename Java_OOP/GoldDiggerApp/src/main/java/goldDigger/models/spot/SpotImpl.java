package goldDigger.models.spot;

import java.util.ArrayList;
import java.util.Collection;

public class SpotImpl implements Spot {
    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name) {
        setName(name);
        exhibits = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Invalid name!");
        }
        this.name = name;
    }
}
