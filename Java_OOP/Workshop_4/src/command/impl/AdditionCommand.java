package command.impl;

import command.CalculatorState;
import command.Command;

public class AdditionCommand implements Command {
    private final Double operand;

    private final CalculatorState calculatorState;

    public AdditionCommand(Double operand, CalculatorState calculatorState) {
        this.operand = operand;
        this.calculatorState = calculatorState;
    }

    @Override
    public void execute() {
        this.calculatorState.setCurrentNumber(calculatorState.getCurrentNumber() + operand);
    }

    public Double getOperand() {
        return operand;
    }
}
