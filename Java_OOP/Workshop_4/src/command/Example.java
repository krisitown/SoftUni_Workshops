package command;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while(!line.equals("Exit")) {
            commandExecutor.executeCommand(line);
            line = scanner.nextLine();
        }
    }
}
