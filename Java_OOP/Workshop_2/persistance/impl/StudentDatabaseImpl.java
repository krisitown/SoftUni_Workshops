package persistance.impl;

import core.data.Student;
import dependency.management.Dependency;
import persistance.StudentDatabase;

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
