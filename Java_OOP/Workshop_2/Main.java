import command.CommandParser;
import command.impl.CommandParserImpl;
import command.impl.ExtendedCommandParser;
import core.StudentSystem;
import core.impl.StudentSystemImpl;
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
        StudentFormatter studentFormatter = new StudentFormatterImpl();
        StudentView studentView = new StudentConsoleView(studentFormatter);
        StudentDatabase studentDatabase = new StudentDatabaseImpl();
        StudentSystem studentSystem = new StudentSystemImpl(studentDatabase, studentView);
        CommandParser commandParser = new ExtendedCommandParser(studentSystem);

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
