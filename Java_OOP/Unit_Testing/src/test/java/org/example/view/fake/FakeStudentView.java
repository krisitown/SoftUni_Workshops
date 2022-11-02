package org.example.view.fake;

import org.example.core.data.Student;
import org.example.view.StudentView;

public class FakeStudentView implements StudentView {
    private Student lastDisplayedStudent;
    @Override
    public void displayStudent(Student student) {
        lastDisplayedStudent = student;
    }

    public Student getLastDisplayedStudent() {
        return lastDisplayedStudent;
    }
}
