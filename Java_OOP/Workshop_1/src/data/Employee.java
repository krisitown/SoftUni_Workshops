package data;

public class Employee {
    private final Long id;
    private final String title;

    public Employee(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Double monthlyCost() {
        return 0.0;
    }

    public static String companyName() {
        return "DXC";
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id + ": " + title;
    }
}
