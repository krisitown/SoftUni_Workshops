package org.example.command.impl;


import org.example.command.CommandParser;
import org.example.core.StudentSystem;
import org.example.dependency.management.Dependency;

public class CommandParserImpl implements CommandParser {
    private final StudentSystem studentSystem;

    public CommandParserImpl(StudentSystem studentSystem) {
        this.studentSystem = studentSystem;
    }

    public void parseCommand(String[] args) {
        if (args[0].equals("Create")) {
            var name = args[1];
            var age = Integer.parseInt(args[2]);
            var grade =Double.parseDouble(args[3]);
            studentSystem.registerStudent(name, age, grade);
        }
        else if (args[0].equals("Show")) {
            var name = args[1];
            studentSystem.displayStudent(name);
        }
    }

    protected StudentSystem getStudentSystem() {
        return studentSystem;
    }
}
