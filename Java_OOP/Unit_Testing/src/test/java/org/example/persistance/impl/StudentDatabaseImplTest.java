package org.example.persistance.impl;

import org.example.core.data.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseImplTest {
    private StudentDatabaseImpl studentDatabase;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabaseImpl();
    }

    @Test
    public void insertStudent_sampleStudentEntered_studentReturnedWhenFetchedByName() {
        Student student = new Student("Pesho", 25, 5d);

        studentDatabase.insertStudent(student);

        assertEquals(student, studentDatabase.getStudentByName("Pesho"));
    }

    @Test
    public void getStudentByName_studentAlreadyExists_expectedTheSameStudent() {
        Student student = new Student("Pesho", 25, 5d);
        studentDatabase.insertStudent(student);

        Student result = studentDatabase.getStudentByName("Pesho");

        assertEquals(student, result);
    }

    @Test
    public void getStudentByName_studentDoesNotExist_expectedNullResponse() {
        Student result = studentDatabase.getStudentByName("John Doe");

        assertNull(result);
    }

    @Test
    public void listStudents_twoStudentsRegistered_expectedListWithTwoStudents() {
        Student studentOne = new Student("Pesho", 35, 5d);
        Student studentTwo = new Student("Gosho", 33, 6d);
        studentDatabase.insertStudent(studentOne);
        studentDatabase.insertStudent(studentTwo);

        List<Student> result = studentDatabase.listStudents();

        assertEquals(2, result.size());
    }

}