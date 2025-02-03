package stream;

import java.util.Arrays;
import java.util.List;

/*Q6. flatMap vs map Use flatMap to process nested lists of strings, and compare with map.*/
public class Q6Stream {
    public static void main(String[] args) {
        //list of banned countries
        List<String> setBlocked = List.of("iraq", "syria", "moldova");

        //list of all countries by their continent
        List<String> asianCountries = List.of("India", "Japan", "China", "Afghanistan", "Thailand", "Russia");
        List<String> europeanCountries = List.of("Germany", "Finland", "Croatia", "Czechia", "Luxumbarg", "Russia", "Turkey");
        List<String> middleEastCountries = List.of("Syria", "Egypt", "UAE", "Turkey");

        //add all countries in one list<list>
        List<List<String>> countr = Arrays.asList(asianCountries, europeanCountries, middleEastCountries);
        System.out.println("==========Using Flatmap=============");
        // this will store all countries in one single list
        countr.stream()
                .flatMap(list -> list.stream())
                .filter(str -> !setBlocked.contains(str))
                .forEach(s -> System.out.print(" " + s));

        System.out.println("\n===========Using Map==============");
        //this will not store all countries in single list instead it stores all list individually
        countr.stream()
                .map(list -> list)
                .forEach(System.out::println);
    }
}
