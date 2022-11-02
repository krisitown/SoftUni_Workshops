package org.example.core.impl;

import org.example.core.data.Student;
import org.example.persistance.StudentDatabase;
import org.example.persistance.impl.StudentDatabaseImpl;
import org.example.view.StudentView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

public class StudentSystemImplMockitoTest {
    @Spy
    private StudentDatabaseImpl studentDatabase;
    @Mock
    private StudentView studentView;

    private StudentSystemImpl studentSystem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        studentSystem = new StudentSystemImpl(studentDatabase, studentView);
    }

    @Test
    public void displayStudent_studentPresent_studentDisplayedProperly() {
        String name = "Pesho";
        Student student = new Student(name, 34, 5d);
        studentDatabase.insertStudent(student);
        when(studentDatabase.getStudentByName(name)).thenReturn(student);

        studentSystem.displayStudent(name);

        verify(studentView, times(1)).displayStudent(student);
    }
}
