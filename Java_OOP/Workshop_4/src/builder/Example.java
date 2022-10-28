package builder;

public class Example {
    public static void main(String[] args) {
//        Human h = new Human(
//                "John",
//                null,
//                33,
//                null,
//                "1000"
//        );

        Human h = Human.builder()
                .withFirstName("John")
                .withAge(33)
                .withPostalCode("1000")
                .build();
    }
}
