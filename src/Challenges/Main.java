package Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        //first solution
        System.out.println("------ first solution-----------");
        topNames2015
                .stream()
                .map(name-> name.substring(0,1).toUpperCase().concat(name.substring(1,name.length())))
                .sorted(String::compareTo)
                .forEach(System.out::println);//without terminal operation stream does not print anything.

        //second solution
        System.out.println("------Second Solution------------");
        List<String> firstUpperCaseList = new ArrayList<>();
      topNames2015.forEach(name->
              firstUpperCaseList.add(name.substring(0,1).toUpperCase().concat(name.substring(1))));
      firstUpperCaseList.sort((s1,s2)-> s1.compareTo(s2));
      //OR ===>firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(name -> System.out.println(name));
        //OR===> firstUpperCaseList.forEach(System.out::println);


       Long startWithA = topNames2015
                .stream()
                .filter(name->name.startsWith("A"))
                .count();
        System.out.println(startWithA);

        //to be sure the names are uppercase
        System.out.println("------Peek method------");
        topNames2015
                .stream()
                .map(name-> name.substring(0,1).toUpperCase().concat(name.substring(1)))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        //OR count()
        //OR forEach these last three line of codes are terminal operations
    }


}
