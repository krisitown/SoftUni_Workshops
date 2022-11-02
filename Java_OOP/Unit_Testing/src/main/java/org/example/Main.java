package org.example;

import org.example.command.CommandParser;
import org.example.command.impl.CommandParserImpl;
import org.example.command.impl.ExtendedCommandParser;
import org.example.core.StudentSystem;
import org.example.core.data.Student;
import org.example.core.impl.StudentSystemImpl;
import org.example.dependency.management.DependencyManager;
import org.example.persistance.StudentDatabase;
import org.example.persistance.impl.StudentDatabaseImpl;
import org.example.view.StudentView;
import org.example.view.formatter.StudentFormatter;
import org.example.view.formatter.impl.StudentFormatterImpl;
import org.example.view.impl.StudentConsoleView;

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
