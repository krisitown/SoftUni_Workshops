package liskov;

public class TrojanHorse extends Horse {
    @Override
    public void eat() {
        throw new UnsupportedOperationException();
    }
}
