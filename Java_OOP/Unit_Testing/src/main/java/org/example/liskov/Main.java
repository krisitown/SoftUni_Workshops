package org.example.liskov;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Horse pesho = new Horse();
        Mustang gosho = new Mustang();
        TrojanHorse sasho = new TrojanHorse();

        List<Horse> horses = new ArrayList<>();
        horses.add(pesho);
        horses.add(gosho);
        horses.add(sasho);

        for (Horse horse : horses) {
            //BAD PRACTICE
            if (!(horse instanceof TrojanHorse)) {
                horse.eat();
            }
        }
    }
}
