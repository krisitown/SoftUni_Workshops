package core.impl;

import core.StudentSystem;
import core.data.Student;
import dependency.management.Dependency;
import persistance.StudentDatabase;
import view.StudentView;

import java.util.List;

@Dependency
public class StudentSystemImpl implements StudentSystem {
    private final StudentDatabase studentDatabase;
    private final StudentView studentView;

    public StudentSystemImpl(StudentDatabase studentDatabase, StudentView studentView) {
        this.studentDatabase = studentDatabase;
        this.studentView = studentView;
    }

    @Override
    public void registerStudent(String name, Integer age, Double grade) {
        var student = new Student(name, age, grade);
        studentDatabase.insertStudent(student);
    }

    @Override
    public void displayStudent(String name) {
        Student student = studentDatabase.getStudentByName(name);
        studentView.displayStudent(student);
    }

    @Override
    public void listStudents() {
        List<Student> students = studentDatabase.listStudents();
        for (Student student : students) {
            studentView.displayStudent(student);
        }
    }
}
