package command;

public class CalculatorState {
    private Double currentNumber = 0d;

    public CalculatorState() {
    }

    public Double getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Double currentNumber) {
        this.currentNumber = currentNumber;
    }
}
