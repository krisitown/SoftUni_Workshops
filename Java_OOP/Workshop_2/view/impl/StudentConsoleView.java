package view.impl;

import core.data.Student;
import dependency.management.Dependency;
import view.StudentView;
import view.formatter.StudentFormatter;

@Dependency
public class StudentConsoleView implements StudentView {
    private final StudentFormatter studentFormatter;

    public StudentConsoleView(StudentFormatter studentFormatter) {
        this.studentFormatter = studentFormatter;
    }

    @Override
    public void displayStudent(Student student) {
        if(student == null) {
            return;
        }

        System.out.println(studentFormatter.formatStudent(student));
    }
}
