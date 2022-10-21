import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Map<String, Student> studentDb = new HashMap<>();
        studentDb.put("1111", new Student("Pesho", "Goshev", 22));
        studentDb.put("1231", new Student("Georgi", "Goshev", 32));
        studentDb.put("4311", new Student("john", "doe", 66));

        // show all student names, who have even ID
        String resultStream = studentDb.entrySet().stream()
                .filter(pair -> Integer.parseInt(pair.getKey()) % 2 == 0)
                .map(pair -> pair.getValue())
                .map(student -> student.getFirstName() + " " + student.getLastName())
                .reduce((student1, student2) -> student1 + ", " + student2)
                .orElse("Default Value!");


        String resultLoop = "";
        for (Map.Entry<String, Student> entry: studentDb.entrySet()) {
            if(Integer.parseInt(entry.getKey()) % 2 == 0) {
                String fullName = entry.getValue().getFirstName() + " " + entry.getValue().getLastName();
                if (resultLoop.equals("")) {
                    resultLoop += fullName;
                } else {
                    resultLoop += ", " + fullName;
                }
            }
        }
        if (resultLoop.equals("")) {
            resultLoop = "Default Value!";
        }

        System.out.println(resultLoop);
        System.out.println(resultStream);
    }

    static Integer factorial(int n) {
        Stream<Integer> naturalNumbers = Stream.iterate(1, i -> i + 1);
        return naturalNumbers
                .map(x -> x*2)
                .filter(x -> x % 3 == 0)
                .reduce((x, y) -> x * y)
                .orElse(1);
    }

    static Integer fold(Integer identity, List<Integer> numbers, BiFunction<Integer, Integer, Integer> combinator) {
        int result = identity;
        for (Integer num : numbers) {
            result = combinator.apply(result, num);
        }

        return result;
    }
}

class Student {
    private String firstName;
    private String lastName;
    private Integer age;

    public Student(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}
