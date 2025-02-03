package stream;

import java.util.Arrays;
import java.util.List;

/*Q2. Summarize Numeric Data with reduce()
Given a list of integers, find the product of all numbers using reduce().*/
public class Q2Stream {
    public static void main(String[] args) {
        //list of numbers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int product = numbers.stream()
                .reduce(1, (number1, number2) -> number1 * number2); //identity 1 which is initial values and then multiply each elements
        System.out.println("stream.Product of all numbers :: " + product);
    }
}
