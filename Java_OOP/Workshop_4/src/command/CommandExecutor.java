package command;

import command.impl.AdditionCommand;
import command.impl.DoubleCommand;
import command.impl.UndoCommand;

public class CommandExecutor {
    private final CalculatorState state = new CalculatorState();
    private Command lastCommand;

    public void executeCommand(String command) {
        String[] tokens = command.split("\\s+");
        Command commandObj = null;
        switch (tokens[0]) {
            case "Add":
                commandObj = new AdditionCommand(Double.parseDouble(tokens[1]), state);
                break;
            case "Double":
                commandObj = new DoubleCommand(state);
                break;
            case "Undo":
                commandObj = new UndoCommand(lastCommand, state);
                break;
        }

        commandObj.execute();
        System.out.println(state.getCurrentNumber());
        lastCommand = commandObj;
    }
}
