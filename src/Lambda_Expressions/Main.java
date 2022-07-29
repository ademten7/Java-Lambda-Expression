package Lambda_Expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Printing from Ruuneable");
            System.out.println("Line 2");
            System.out.format("This is line  %d\n", 3);
        }).start();

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



        /*
        Collections.sort(employees, new Comparator<Lambda_Expressions.Employee>() {
            @Override
            public int compare(Lambda_Expressions.Employee employee1, Lambda_Expressions.Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });*/
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
        UpperConcat uc = (s1,s2)-> {
          String result =  s1.toUpperCase() + s2.toUpperCase();
            System.out.println("result = " + result);
        return result;
        };
       String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
       System.out.println(sillyString);

       AnotherClass anotherClass = new AnotherClass();
       String s = anotherClass.doSomething();
        System.out.println("s = " + s);

    }
    public final static String doStringStuff (UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);

    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
interface  UpperConcat{
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){
       UpperConcat uc = (s1, s2) -> {
           System.out.println("The lambda expressions class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
       };
        System.out.println("The another class name is "+ getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1 " , " String2");
    }
    public void printValue(){
        int number = 25;
        Runnable r =()-> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("number = " + number);
        };
        new Thread().start();
    }
}
