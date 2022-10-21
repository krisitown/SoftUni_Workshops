import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Car> cars = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            Car car = new Car(
                    tokens[0],
                    Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]));

            cars.add(car);
        }

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split(" ");
            Car targetCar = cars.stream()
                    .filter(car -> car.getModel().equals(tokens[1]))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Car in drive command doesn't exist!"));

            targetCar.drive(Double.parseDouble(tokens[2]));
            line = scanner.nextLine();
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}