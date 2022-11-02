package org.example.view.formatter.impl;

import org.example.core.data.Student;
import org.example.dependency.management.Dependency;
import org.example.view.formatter.StudentFormatter;

@Dependency
public class StudentFormatterImpl implements StudentFormatter {
    @Override
    public String formatStudent(Student student) {
        String view = String.format("%s is %s years old.",student.getName(),student.getAge());

        if (student.getGrade() >= 5.00)
        {
            view += " Excellent student.";
        }
        else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
        {
            view += " Average student.";
        }
        else {
            view += " Very nice person.";
        }

        return view;
    }
}
