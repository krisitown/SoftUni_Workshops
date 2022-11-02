package org.example.view.impl;

import org.example.core.data.Student;
import org.example.dependency.management.Dependency;
import org.example.view.StudentView;
import org.example.view.formatter.StudentFormatter;

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
