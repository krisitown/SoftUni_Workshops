package org.example.liskov;

public class TrojanHorse extends Horse {
    @Override
    public void eat() {
        throw new UnsupportedOperationException();
    }
}
