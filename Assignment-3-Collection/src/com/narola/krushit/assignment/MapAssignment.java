package com.narola.krushit.assignment;

import java.util.*;

public class MapAssignment {
    public static void main(String[] args) {
        Map<String, String> hm = new HashMap<>();

        //Add key-value pairs to a Map.
        hm.put("Belgium", "Namur");
        hm.put("Croatia", "Zagreb");
        hm.put("Ireland", "Dublin");
        hm.put("Finland", "Helsinki");
        hm.put("Belgium", "Brussels");
        hm.put("Germany", "Berlin");


        MapAssignment mapAssignment = new MapAssignment();
        mapAssignment.hashMapOps(hm);

        String string = "Java is Good Java is high level programming language it is easy to learn";
        mapAssignment.countFrequency(string);

        List<Student> studentList = List.of(new Student(3, "Krushit"),
                new Student(2, "Sujal"),
                new Student(1, "Ami"));
        mapAssignment.sortingWithTreemap(studentList);

        mapAssignment.convertMapToList(hm);
    }

    /**
     * Assignment 1: Basic Map Operations
     * 1. Create a program to:
     * ○ Add key-value pairs to a Map.
     * ○ Retrieve a value by key.
     * ○ Check if a key or value exists.
     * ○ Remove a key-value pair.
     * ○ Iterate over the Map using:
     * ■ keySet
     * ■ entrySet
     * ■ values
     * ○ Use HashMap for the above tasks.
     */
    public void hashMapOps(Map<String, String> hm) {
        System.out.println("HashMap :; " + hm);

        //Retrieve a value by key.
        for (String country : hm.keySet()) {
            System.out.println("Capital of " + country + " is " + hm.get(country));
        }

        //Check if a key or value exists.
        System.out.println("Belgium :: HashMap Contains??" + hm.containsKey("Belgium"));

        //Remove a key-value pair.
        System.out.println("After removing Croatia from Map :: " + hm.remove("Croatia"));

        //Iterate over the Map using:
        //■ keySet
        //■ entrySet
        //■ values

        //keySet
        System.out.println("\tUsing KeySet");
        for (String country : hm.keySet()) {
            System.out.println("Capital of " + country + " is " + hm.get(country));
        }

        //entrySet
        System.out.println("\tUsing Entry Set");
        System.out.println("\t--------------------------");
        System.out.println("\t|  Country\t|  Capital \t|");
        System.out.println("\t--------------------------");
        for (Map.Entry<String, String> entry : hm.entrySet()) {
            System.out.println("\t|  " + entry.getKey() + " \t|  " + entry.getValue() + "\t|");
        }

        //values
        System.out.println("\tUsing Values");
        for (String capital : hm.values()) {
            System.out.println(capital);
        }
    }

    /**
     * Assignment 2: Count Word Frequency
     * ● Write a program to count the frequency of words in a paragraph using a HashMap.
     *
     * @param string
     */
    public void countFrequency(String string) {
        Map<String, Integer> hm = new HashMap();
        String[] words = string.split(" ");

        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nHashMap :: " + hm);
    }

    /**
     * Assignment 3: Sorting with TreeMap
     * ● Store student IDs (keys) and their names (values) in a TreeMap. Display the sorted
     *      entries by ID.
     * @param studentList
     */
    public void sortingWithTreemap(List<Student> studentList) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        for(Student student : studentList){
            treeMap.put(student.id, student.name);
        }

        System.out.println("Treemap:: " + treeMap);
    }

    /**
     * Assignment 4: Convert Map to List
     * ● Convert a Map into two separate lists:
     * ○ A list of keys.
     * ○ A list of values.
     * @param hashmap
     */
    public void convertMapToList(Map<String, String> hashmap){
        List<String> country = new ArrayList<>();
        List<String> capital = new ArrayList<>();

        for(Map.Entry<String, String> entry : hashmap.entrySet()){
            country.add(entry.getKey());
            capital.add(entry.getValue());
        }

        System.out.println("Country List :: " + country);
        System.out.println("Capital List :: " + capital);
    }
}
