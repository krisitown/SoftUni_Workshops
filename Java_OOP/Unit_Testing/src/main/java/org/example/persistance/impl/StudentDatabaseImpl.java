package org.example.persistance.impl;

import org.example.core.data.Student;
import org.example.dependency.management.Dependency;
import org.example.persistance.StudentDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Dependency
public class StudentDatabaseImpl implements StudentDatabase {
    private final Map<String, Student> repo;

    public StudentDatabaseImpl() {
        this.repo = new HashMap<>();
    }

    @Override
    public void insertStudent(Student student) {
        if(!repo.containsKey(student.getName())) {
            repo.put(student.getName(), student);
        }
    }

    @Override
    public Student getStudentByName(String name) {
        return repo.get(name);
    }

    @Override
    public List<Student> listStudents() {
        return new ArrayList<>(repo.values());
    }
}
