package command.impl;

import command.CalculatorState;
import command.Command;

public class DoubleCommand implements Command {
    private final CalculatorState state;

    public DoubleCommand(CalculatorState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        this.state.setCurrentNumber(this.state.getCurrentNumber() * 2);
    }
}
