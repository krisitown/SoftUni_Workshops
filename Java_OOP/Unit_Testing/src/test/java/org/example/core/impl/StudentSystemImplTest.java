package org.example.core.impl;

import org.example.persistance.impl.StudentDatabaseImpl;
import org.example.view.fake.FakeStudentView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentSystemImplTest {
    @Test
    public void displayStudent_studentPresent_studentDisplayedProperly() {
        FakeStudentView fakeStudentView = new FakeStudentView();
        StudentDatabaseImpl studentDatabase = new StudentDatabaseImpl();
        StudentSystemImpl studentSystem = new StudentSystemImpl(studentDatabase, fakeStudentView);
        String name = "Pesho";
        Integer age = 34;
        Double grade = 5.0d;
        studentSystem.registerStudent(name, age, grade);

        studentSystem.displayStudent(name);

        assertEquals(name, fakeStudentView.getLastDisplayedStudent().getName());
        assertEquals(age, fakeStudentView.getLastDisplayedStudent().getAge());
        assertEquals(grade, fakeStudentView.getLastDisplayedStudent().getGrade());
    }

}