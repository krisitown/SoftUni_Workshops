import data.Contractor;
import data.Eater;
import data.Employee;
import data.FullTimeEmployee;
import generator.EmployeeGenerator;
import generator.LawyerFTEmployeeGenerator;
import generator.SoftwareEngineerFTEmployeeGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Contractor c = new Contractor(1l, "SWE", 1234123d);
        c.eat();

        SoftwareEngineerFTEmployeeGenerator sweFtEmployeeGenerator = new SoftwareEngineerFTEmployeeGenerator();
        LawyerFTEmployeeGenerator lawyerFTEmployeeGenerator = new LawyerFTEmployeeGenerator();

        FullTimeEmployee pesho = sweFtEmployeeGenerator.generate(600d);
        FullTimeEmployee gosho = lawyerFTEmployeeGenerator.generate(700d);

        System.out.println(pesho);
        System.out.println(gosho);

        List<Employee> employees = new ArrayList<>();
        employees.add(pesho);
        employees.add(gosho);
        employees.add(c);

        Employee emp = new FullTimeEmployee(1l, "swe", 323.0);
        System.out.println("*****");

        for (Employee e : employees) {
            if(e instanceof FullTimeEmployee) {
                System.out.println(((FullTimeEmployee)e).getSalary());
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        sublist(sublist(list, 1, 2), 1, 4);
    }

    private static List<Integer> sublist(List<Integer> list, int start, int end) {
        ArrayList<Integer> sublist = new ArrayList<>();
        for (int i = start; i < end; i++) {
            sublist.add(list.get(i));
        }
        return sublist;
    }
}