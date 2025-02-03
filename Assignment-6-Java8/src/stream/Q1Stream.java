package stream;

import java.util.Arrays;
import java.util.List;

/*Q1. Filter and Sort Lists with Streams Write a program to filter out
strings shorter than 4 characters and sort the remaining strings alphabetically.*/
public class Q1Stream {
    public static void main(String[] args) {
        //list of countries
        List<String> countries = Arrays.asList("india", "australia", "oman", "china", "russia", "cuba", "iran");
        List<String> filterAndSortedStream = countries.stream()
                .filter(country -> country.length() > 4) //filter countries with sort names
                .sorted() //sort remaining words alphabetically
                .toList();
        System.out.println("filterAndSortedStream :: " + filterAndSortedStream);
    }
}
