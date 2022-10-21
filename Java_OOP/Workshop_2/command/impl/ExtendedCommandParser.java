package command.impl;


import core.StudentSystem;
import dependency.management.Dependency;

@Dependency
public class ExtendedCommandParser extends CommandParserImpl {
    public ExtendedCommandParser(StudentSystem studentSystem) {
        super(studentSystem);
    }

    @Override
    public void parseCommand(String[] args) {
        super.parseCommand(args);

        if(args[0].equals("List")) {
            getStudentSystem().listStudents();
        }
    }
}
