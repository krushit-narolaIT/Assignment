import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAssignment {
    public static void main(String[] args) {
        System.out.println("============================  Q1  =================================");
        /*Q1. Filter and Sort Lists with Streams Write a program to filter out
        strings shorter than 4 characters and sort the remaining strings alphabetically.*/
        List<String> countries = Arrays.asList("india", "australia", "oman", "china", "russia", "cuba", "iran");
        List<String> filterAndSortedStream = countries.stream()
                .filter(country -> country.length() > 4)
                .sorted()
                .toList();
        System.out.println("filterAndSortedStream :: " + filterAndSortedStream);

        System.out.println("============================  Q2  =================================");
        /*Q2. Summarize Numeric Data with reduce()
        Given a list of integers, find the product of all numbers using reduce().*/
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int product = numbers.stream()
                .reduce(1, (number1, number2) -> number1 * number2);
        System.out.println("Product of all numbers :: " + product);

        System.out.println("============================  Q3  =================================");
        /*Q3.Group Objects by Category Create a Product class with name and category.
        Group products by their category using Collectors.groupingBy.*/
        class Product {
            String name;
            String category;

            public Product(String name, String category) {
                this.name = name;
                this.category = category;
            }

            public String getName() {
                return name;
            }

            public String getCategory() {
                return category;
            }

            @Override
            public String toString() {
                return name;
            }
        }

        List<Product> products = Arrays.asList(
                new Product("TV", "Electronics"),
                new Product("Bike", "Vehicle"),
                new Product("Fridge", "Electronics"),
                new Product("BMW", "Vehicle"),
                new Product("Table", "Furniture")
        );

        products.stream()
                .collect(Collectors.groupingBy(prod -> prod.getCategory()))
                .forEach((category, items) -> System.out.println(category + ": " + items));

        System.out.println("============================  Q4  =================================");

        /*Q4.Experiment with Parallel Streams Compare the performance of sequential
        vs parallel streams for a CPU-intensive computation (e.g., calculating primes).*/
        List<Integer> integerList = IntStream.range(1, 999).boxed().collect(Collectors.toList());
        long start = System.currentTimeMillis();
        long isPrimeSequencial = integerList.stream().filter(number -> StreamAssignment.isPrime(number)).count();
        long end = System.currentTimeMillis();
        System.out.println("Time taken by sequencial stream ::" + (end - start) + " ms");

        start = System.currentTimeMillis();
        long isPrimeParallel = integerList.parallelStream().filter(number -> StreamAssignment.isPrime(number)).count();
        end = System.currentTimeMillis();
        System.out.println("Time taken by Parallel stream ::" + (end - start) + " ms");

        System.out.println("============================  Q5  =================================");
        /*Q5.Custom Collectors Implement a custom Collector to calculate the product of numbers in a stream.*/
        int productOfNumberInStream = IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .collect(Collector.of(
                        () -> new int[]{1},
                        (a, b) -> a[0] *= b,
                        (a1, a2) -> {
                            a1[0] *= a2[0];
                            return a1;
                        },
                        a -> a[0]
                ));
        System.out.println("Product: " + productOfNumberInStream);

        System.out.println("============================  Q6  =================================");
        /*Q6. flatMap vs map Use flatMap to process nested lists of strings, and compare with map.*/
        List<String> setBlocked = List.of("iraq", "syria", "moldova");
        List<String> asianCountries = List.of("India", "Japan", "China", "Afghanistan", "Thailand", "Russia");
        List<String> europeanCountries = List.of("Germany", "Finland", "Croatia", "Czechia", "Luxumbarg", "Russia", "Turkey");
        List<String> middleEastCountries = List.of("Syria", "Egypt", "UAE", "Turkey");

        List<List<String>> countr = Arrays.asList(asianCountries, europeanCountries, middleEastCountries);
        System.out.println("==========Using Flatmap=============");
        countr.stream()
                .flatMap(list -> list.stream())
                .filter(str -> !setBlocked.contains(str))
                .forEach(s -> System.out.print(" " + s));

        System.out.println("\n===========Using Map==============");
        countr.stream()
                .map(list -> list)
                .forEach(System.out::println);

        System.out.println("============================  Q7  =================================");
        /*Q7. Stream Performance Analyze the performance of spliterator
        and learn tips for efficient parallelization.*/
        List<Integer> numbersList = IntStream.rangeClosed(1, 999).boxed().toList();
        Stream<Integer> str1 = numbersList.stream();

        long startNow = System.currentTimeMillis();
        Spliterator<Integer> spliterator1 = str1.spliterator();
        Spliterator<Integer> spliterator2 = spliterator1.trySplit();

        System.out.println("\nOutput from spliterator1: ");
        spliterator1.forEachRemaining((n) -> System.out.print(n + " "));

        System.out.println("\nOutput from spliterator: ");
        spliterator2.forEachRemaining((n) -> System.out.print(n + " "));
        long endNow = System.currentTimeMillis();
        System.out.println("\nTime Taken by Splititerator :: " + (endNow - startNow));

        System.out.println("===================");
        Stream<Integer> str2 = numbersList.stream();
        startNow = System.currentTimeMillis();
        Iterator<Integer> iterator = numbersList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        endNow = System.currentTimeMillis();
        System.out.println("\nTime Taken by Iterator :: " + (endNow - startNow));

        System.out.println("\n============================  Q8  =================================");
        /*Q8. Custom Collector for Aggregation Write a custom collector to
        aggregate employee salaries into a department-wise total.*/

        class Employee {
            String name;
            String department;
            int salary;

            public Employee(String name, String department, int salary) {
                this.department = department;
                this.salary = salary;
            }

            public String getName() {
                return name;
            }

            public String getDepartment() {
                return department;
            }

            public int getSalary() {
                return salary;
            }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Krushit", "JAVA", 15000),
                new Employee("D.Shah", "HR", 12000),
                new Employee("Rahul", "PYTHON", 18000),
                new Employee("Vinay", "JAVA", 15000)
        );

        Map<String, Integer> departmentSalary = employees.stream()
                .collect(Collector.of(
                        HashMap::new,
                        (hashMap, employee) -> hashMap.merge(employee.getDepartment(), employee.getSalary(), Integer::sum),
                        (map1, map2) -> {
                            map2.forEach((k, v) -> map1.merge(k, v, Integer::sum));
                            return map1;
                        }
                ));

        System.out.println(departmentSalary);

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
