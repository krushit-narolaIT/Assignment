package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*Q4.Experiment with Parallel Streams Compare the performance of sequential
vs parallel streams for a CPU-intensive computation (e.g., calculating primes).*/
public class Q4Stream {
    public static void main(String[] args) {
        //list of integers
        List<Integer> integerList = IntStream.range(1, 999999).boxed().collect(Collectors.toList());
        long start = System.currentTimeMillis();
        //count prime numbers using sequencial stream
        long isPrimeSequencial = integerList.stream().filter(number -> Q4Stream.isPrime(number)).count();
        long end = System.currentTimeMillis();
        System.out.println("Time taken by sequencial stream ::" + (end - start) + " ms");

        start = System.currentTimeMillis();
        //count prime numbers using parallel stream
        long isPrimeParallel = integerList.parallelStream().filter(number -> Q4Stream.isPrime(number)).count();
        end = System.currentTimeMillis();
        System.out.println("Time taken by Parallel stream ::" + (end - start) + " ms");
    }

    public static boolean isPrime(Integer number) {
        if (number <= 1) return false;

        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
