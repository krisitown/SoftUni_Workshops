package org.example.liskov;

public class Mustang extends Horse {
    @Override
    public void eat() {
        System.out.println("Mustang is eating!");
    }
}
