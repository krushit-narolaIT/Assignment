package com.narola.krushit;

interface User {
    public void getName();
}

class Customer implements User {
    @Override
    public void getName() {
        System.out.println("My name is Krushit");
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        //Without functional programming
        Customer customer = new Customer();
        customer.getName();

        //With functional programming
        User user = new User() {
            @Override
            public void getName() {
                System.out.println("Hi My Name is krushit");
            }
        };
        user.getName();

        //using lambda exp
        User user1 = () -> System.out.println("Hi My name is Krushit");
        user1.getName();

        //using anonumous class
        new User() {
            @Override
            public void getName() {
                System.out.println("Hello my name is krushit");
            }
        }.getName();
    }
}
