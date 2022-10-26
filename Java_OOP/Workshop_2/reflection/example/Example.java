package reflection.example;

import persistance.StudentDatabase;
import view.StudentView;
import view.formatter.StudentFormatter;

import java.lang.reflect.Method;

public class Example {
    public static void main(String[] args) throws Exception {
        Class studentSystemClass = Class.forName("core.impl.StudentSystemImpl");
        Class studentViewClass = Class.forName("view.impl.StudentConsoleView");
        Class studentFormatterClass = Class.forName("view.formatter.impl.StudentFormatterImpl");
        Class studentDatabaseClass = Class.forName("persistance.impl.StudentDatabaseImpl");

        Object studentDatabase = studentDatabaseClass.getDeclaredConstructor().newInstance();
        Object studentFormatter = studentFormatterClass.getDeclaredConstructor().newInstance();
        Object studentView = studentViewClass.getDeclaredConstructor(StudentFormatter.class)
                .newInstance(studentFormatter);
        Object studentSystem = studentSystemClass.getDeclaredConstructor(StudentDatabase.class, StudentView.class)
                .newInstance(studentDatabase, studentView);

        Method registerStudent = studentSystemClass.getDeclaredMethod("registerStudent",
                String.class, Integer.class, Double.class);
        registerStudent.invoke(studentSystem,"Pesho", 22, 5.0);

        Method displayStudent = studentSystemClass.getDeclaredMethod("displayStudent", String.class);
        displayStudent.invoke(studentSystem, "Pesho");
    }
}
