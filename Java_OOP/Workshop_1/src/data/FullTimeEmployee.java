package data;

public class FullTimeEmployee extends Employee {
    private Double salary;

    public FullTimeEmployee(Long id, String title, Double salary) {
        super(id, title);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public Double monthlyCost() {
        return salary;
    }
}
