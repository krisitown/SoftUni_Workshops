package org.example.persistance;

import org.example.core.data.Student;

import java.util.List;

public interface StudentDatabase {
    void insertStudent(Student student);
    Student getStudentByName(String name);
    List<Student> listStudents();
}
