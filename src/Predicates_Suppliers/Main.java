package Predicates_Suppliers;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John White", 32);
        Employee tim = new Employee("Tim Bucka", 42);
        Employee adem = new Employee("Adem Te", 45);
        Employee müller = new Employee("Müller White", 22);
        Employee red = new Employee("Red Hack", 25);
        Employee snow = new Employee("Snow Karlsten" , 33);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(adem);
        employees.add(müller);
        employees.add(red);
        employees.add(snow);



        System.out.println("*********** forEach *************** ");
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        //PREDICATE INTERFACE

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge()>30);
        printEmployeesByAge(employees,"\nEmployees 30 and under ", employee -> employee.getAge()<=30);

        //instead of lambda we can use also consumer
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()<25;
            }
        });

        //we can use also int, double, long, boolean  Predicate
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;

        //test means if condition
        System.out.println(greaterThan15.test(10));//false
        System.out.println(lessThan100.test(90));//true
        System.out.println(greaterThan15.and(lessThan100).test(67));//true


        //SUPPLIER INTERFACE
        //supplier does not accept any arguments and it does return value.
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("===================");
        for (Employee employee: employees){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}
