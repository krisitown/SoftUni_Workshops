package command.impl;

import command.CalculatorState;
import command.Command;

public class UndoCommand implements Command {
    private Command command;
    private CalculatorState calculatorState;

    public UndoCommand(Command command, CalculatorState calculatorState) {
        this.command = command;
        this.calculatorState = calculatorState;
    }

    @Override
    public void execute() {
        if(command instanceof AdditionCommand) {
            AdditionCommand additionCommand = (AdditionCommand) command;
            Double operand = additionCommand.getOperand();
            this.calculatorState.setCurrentNumber(this.calculatorState.getCurrentNumber() - operand);
        } else if (command instanceof DoubleCommand) {
            this.calculatorState.setCurrentNumber(this.calculatorState.getCurrentNumber() / 2d);
        } else if (command instanceof UndoCommand) {
            UndoCommand undoCommand = (UndoCommand) command;
            undoCommand.getCommand().execute();
        }
    }

    public Command getCommand() {
        return command;
    }
}
