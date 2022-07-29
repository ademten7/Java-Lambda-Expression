package FunctionalInterfaces_Predicates_Suppliers;



import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John White", 32);
        Employee tim = new Employee("Tim Bucka", 42);
        Employee adem = new Employee("Adem Te", 45);
        Employee müller = new Employee("Müller White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(adem);
        employees.add(müller);

        System.out.println("*********** forEach *************** ");
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }
}
