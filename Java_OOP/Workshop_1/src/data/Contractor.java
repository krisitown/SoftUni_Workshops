package data;

public class Contractor extends Employee implements Eater {
    private Double contractValue;

    public Contractor(Long id, String title, Double contractValue) {
        super(id, title);
        this.contractValue = contractValue;
    }

    public Double getContractValue() {
        return contractValue;
    }

    @Override
    public Double monthlyCost() {
        return contractValue / 12;
    }

    @Override
    public void eat() {
        System.out.println("data.Contractor is eating");
    }
}
