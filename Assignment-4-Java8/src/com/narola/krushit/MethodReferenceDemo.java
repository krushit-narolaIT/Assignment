package com.narola.krushit;

import java.util.Map;

class Country {
    public static void printMapEntry(String key, String value) {
        System.out.println(key + " -> " + value);
    }

    public static void print() {
        Map<String, String> hm = Map.of("India", "Delhi", "China", "Beijing");
        hm.forEach(Country::printMapEntry);
    }
}

public class MethodReferenceDemo {
    public static void main(String[] args) {
        Country.print();
    }
}
