package liskov;

public class Horse {
    private int numberOfLegs = 4;

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void eat() {
        System.out.println("Horse is eating");
    }
}
