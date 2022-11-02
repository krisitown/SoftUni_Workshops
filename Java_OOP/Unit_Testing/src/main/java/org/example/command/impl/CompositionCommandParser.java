package org.example.command.impl;

public class CompositionCommandParser {
    private final CommandParserImpl commandParser;

    public CompositionCommandParser(CommandParserImpl commandParser) {
        this.commandParser = commandParser;
    }

    public void parseCommand(String[] args) {
        commandParser.parseCommand(args);

        if (args[0].equals("List")) {
            commandParser.getStudentSystem().listStudents();
        }
    }
}
