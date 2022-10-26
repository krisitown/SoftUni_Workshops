import command.CommandParser;
import command.impl.CommandParserImpl;
import command.impl.ExtendedCommandParser;
import core.StudentSystem;
import core.data.Student;
import core.impl.StudentSystemImpl;
import dependency.management.DependencyManager;
import persistance.StudentDatabase;
import persistance.impl.StudentDatabaseImpl;
import view.StudentView;
import view.formatter.StudentFormatter;
import view.formatter.impl.StudentFormatterImpl;
import view.impl.StudentConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Initializing Dependencies
        DependencyManager dependencyManager = new DependencyManager(
                CommandParserImpl.class,
                CommandParser.class,
                StudentSystem.class,
                StudentSystemImpl.class,
                StudentDatabase.class,
                StudentDatabaseImpl.class,
                StudentFormatter.class,
                StudentFormatterImpl.class,
                StudentConsoleView.class,
                StudentView.class
        );

        CommandParser commandParser = dependencyManager.createInstance(CommandParser.class);
        CommandParser commandParserDynamic = dependencyManager.createInstance("command.CommandParser");
        System.out.println(commandParser.equals(commandParserDynamic));

        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Exit")){
                break;
            }
            commandParser.parseCommand(input);
        }
    }
}
