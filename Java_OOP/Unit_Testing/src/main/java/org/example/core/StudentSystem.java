package org.example.core;

import org.example.core.data.Student;

public interface StudentSystem {
    void registerStudent(String name, Integer age, Double grade);
    void displayStudent(String name);
    void listStudents();
}
