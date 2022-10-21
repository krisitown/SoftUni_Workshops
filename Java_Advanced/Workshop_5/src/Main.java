import java.lang.reflect.Type;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nameTokens = scanner.nextLine().split(" ");
        Tuple<String, String> nameAndAddress = new Tuple<>(nameTokens[0] + " " + nameTokens[1], nameTokens[2]);

        String[] beerTokens = scanner.nextLine().split(" ");
        Tuple<String, Integer> beerTuple = new Tuple<>(beerTokens[0], Integer.parseInt(beerTokens[1]));

        String[] numericTokens = scanner.nextLine().split(" ");
        Tuple<Integer, Double> numericTuple = new Tuple<>(Integer.parseInt(numericTokens[0]), Double.parseDouble(numericTokens[1]));

        System.out.println(nameAndAddress);
        System.out.println(beerTuple);
        System.out.println(numericTuple);

        Tuple<Integer, Tuple<Integer, Integer>> triplet = new Tuple<>(1, new Tuple<>(2, 3));
    }
}