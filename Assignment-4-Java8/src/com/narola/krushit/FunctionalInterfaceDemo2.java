package com.narola.krushit;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo2 {
    public static void main(String[] args) {
        System.out.println("===============|| Consumer ||================");
        Consumer<String> consumer = s -> System.out.println("Hello, My name is " + s);
        consumer.accept("Krushit");

        Consumer<String> consumer1 = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("Hello, my name is " + o.toString());
            }
        };
        consumer1.accept("Krushit");

        new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello my name is : " + s);
            }
        }.accept("Krushit");
        System.out.println("===============|| Predicate ||================");

        if(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                Set<String> set = Set.of("germany", "ireland", "finland", "scotland");
                if(set.contains(name.toLowerCase())){
                   return true;
                }
                return false;
            }
        }.test("romania")){
            System.out.println("Yes this is European Country");
        } else {
            System.out.println("This is not European Country");
        }

        ((Predicate<String>) name -> {
            Set<String> set = Set.of("germany", "ireland", "finland", "scotland");
            if (set.contains(name.toLowerCase())) {
                return true;
            }
            return false;
        }).test("romania");

        if (((Predicate<String>) name -> name.equalsIgnoreCase("krushit")).test("krushit")) {
            System.out.println("You Entered Krushit");
        } else {
            System.out.println("Wrong input added");
        }
        Predicate<Integer> firstCall = num -> num > 10;

        Predicate<Integer> secondCall = num -> num < 20;
        boolean result = firstCall.and(secondCall).test(15);
        System.out.println(result);

        System.out.println("===============|| Supplier ||================");
        Supplier<List<String>> getStateList = new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                List<String> stateList = List.of("Gujarat", "Maharastra", "Rajasthan", "UP", "Odisa");
                return stateList;
            }
        };

        System.out.println("Get State List :: " + getStateList.get());

        System.out.println("===============|| Function ||================");
        Function<Double, Double> sqrtOfNum = new Function<Double, Double>() {
            @Override
            public Double apply(Double num) {
                return Math.sqrt(num);
            }
        };
        System.out.println("Square Root of :: " + sqrtOfNum.apply(5.0));
        System.out.println("Square Root of :: " + sqrtOfNum.apply(-5.0));

        new Function<Double, Double>() {
            @Override
            public Double apply(Double km) {
                Double mile = km * 0.621371;
                System.out.println(km  +" is equal to " + mile +" mile");
                return mile;
            }
        }.apply(1.0);

        ((Function<Double, Double>) km -> {
            Double mile = km * 0.621371;
            System.out.println(km + " is equal to " + mile + " mile");
            return mile;
        }).apply(1.0);


    }
}