package com.narola.krushit;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo2 {
    public static void main(String[] args) {
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

        //chaining
        Predicate<Integer> firstCall = num -> num > 10;

        // Creating predicate
        Predicate<Integer> secondCall = num -> num < 20;
        boolean result = firstCall.and(secondCall).test(15);
        System.out.println(result);

        boolean result2 = firstCall.and(secondCall).negate().test(15);
        System.out.println(result2);
    }
}