package com.narola.krushit.assignment;

import java.util.*;

public class SetAssignment {
    public static void main(String[] args) {
        SetAssignment setAssignment = new SetAssignment();
        System.out.println("================= Hashset Operations =================");
        setAssignment.hashSetOps();

        System.out.println("================= LinkedHashSet Operations =================");
        setAssignment.linkedHashSet();

        System.out.println("================= TreeSet Operations =================");
        setAssignment.treeSet();

        System.out.println("=========   Assignment 2     =============");
        String str = "Java is good, Java is high level programming language";
        setAssignment.removeDuplicateWord(str);

        System.out.println("=========   Assignment 3     =============");
        Set<String> setAsia = Set.of("India", "Afghanistan", "Russia", "Turkey");
        Set<String> setEurope = Set.of("Russia", "Turkey", "Germany", "Switzerland");
        setAssignment.setOperations(setAsia, setEurope);

        System.out.println("=========   Assignment 4     =============");
        List<Integer> integerList = List.of(1, 5, 10, 3, 45, 8);
        setAssignment.sortUsingTreeSet(integerList);
    }

    public void hashSetOps(){
        //Assignment 1: Basic Set Operation
        //Add elements to a Set.
        Set<String> hashSet = new HashSet<>();
        hashSet.add("India");
        hashSet.add("Ireland");
        hashSet.add("India"); // duplicate not allow
        hashSet.add("Finland");
        hashSet.add("Maxico");

        System.out.println("Set:: " + hashSet); //not maintain insertion order

        //Remove elements from a Set.
        hashSet.remove("Maxico");
        System.out.println("Set After removing maxico:: " + hashSet);

        //Check if an element exists in a Set.
        System.out.println("Is india present in set :: " + hashSet.contains("India"));

        /*
        Iterate over a Set using:
            ■ Enhanced for loop
            ■ Iterator
            ■ Stream
         */

        //using Enhanced for loop
        System.out.println("\nUsing hashset");
        for(String str : hashSet)
            System.out.print(" " + str);

        //using iterator
        System.out.println("\nUsing Iterator");
        Iterator itr = hashSet.iterator();
        while (itr.hasNext()){
            System.out.print(" " + itr.next());
        }

        //using stream
        System.out.println("\nUsing Stream");
        hashSet.stream().forEach(str -> System.out.print(" " + str));
    }

    public void linkedHashSet(){
        //Assignment 1: Basic Set Operation
        //Add elements to a Set.
        Set<String> linkedHashSet = new HashSet<>();
        linkedHashSet.add("India");
        linkedHashSet.add("Ireland");
        linkedHashSet.add("India"); // duplicate not allow
        linkedHashSet.add("Finland");
        linkedHashSet.add("Maxico");

        System.out.println("Set:: " + linkedHashSet); //preserve insertion order

        //Remove elements from a Set.
        linkedHashSet.remove("Maxico");
        System.out.println("Set After removing maxico:: " + linkedHashSet);

        //Check if an element exists in a Set.
        System.out.println("Is india present in set :: " + linkedHashSet.contains("India"));

        /*
        Iterate over a Set using:
            ■ Enhanced for loop
            ■ Iterator
            ■ Stream
         */

        //using Enhanced for loop
        System.out.println("\nUsing hashset");
        for(String str : linkedHashSet)
            System.out.print(" " + str);

        //using iterator
        System.out.println("\nUsing Iterator");
        Iterator itr = linkedHashSet.iterator();
        while (itr.hasNext()){
            System.out.print(" " + itr.next());
        }

        //using stream
        System.out.println("\nUsing Stream");
        linkedHashSet.stream().forEach(str -> System.out.print(" " + str));
    }

    public void treeSet(){
        //Assignment 1: Basic Set Operation
        //Add elements to a Set.
        Set<String> treeSet = new HashSet<>();
        treeSet.add("India");
        treeSet.add("Ireland");
        treeSet.add("India"); // duplicate not allow
        treeSet.add("Finland");
        treeSet.add("Maxico");

        System.out.println("Set:: " + treeSet); //preserve natural sorting order

        //Remove elements from a Set.
        treeSet.remove("Maxico");
        System.out.println("Set After removing maxico:: " + treeSet);

        //Check if an element exists in a Set.
        System.out.println("Is india present in set :: " + treeSet.contains("India"));

        /*
        Iterate over a Set using:
            ■ Enhanced for loop
            ■ Iterator
            ■ Stream
         */

        //using Enhanced for loop
        System.out.println("\nUsing hashset");
        for(String str : treeSet)
            System.out.print(" " + str);

        //using iterator
        System.out.println("\nUsing Iterator");
        Iterator itr = treeSet.iterator();
        while (itr.hasNext()){
            System.out.print(" " + itr.next());
        }

        //using stream
        System.out.println("\nUsing Stream");
        treeSet.stream().forEach(str -> System.out.print(" " + str));
    }

    /**
     * Assignment 2: Remove Duplicates
     * ● Write a program to remove duplicate words from a sentence using a Set.
     * @param str
     */
    public void removeDuplicateWord(String str){
        System.out.println("\n============================================");
        String[] words = str.split(" ");

        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        String result = String.join(" ", uniqueWords);
        System.out.println("Unique String :: " + result);
    }

    /**
     * Assignment 3: Union, Intersection, and Difference
     * ● Write a program to perform set operations:
     * ○ Union: Combine two sets.
     * ○ Intersection: Find common elements in two sets.
     * ○ Difference: Find elements in one set but not the other.
     * @param set1
     * @param set2
     */
    public void setOperations(Set<String> set1, Set<String> set2){
        //set1.addAll(set2);
        Set<String> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("\nUnion Set :: " + unionSet);

        Set<String> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("\nIntersection Operation :: " + intersectionSet);

        Set<String> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        System.out.println("\nDifference Set :: " + differenceSet);
    }

    /**
     * Assignment 4: Sort Using TreeSet
     * ● Use a TreeSet to store and display a list of integers in ascending order
     */
    public void sortUsingTreeSet(List<Integer> integerList){
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Integer integer : integerList){
            treeSet.add(integer);
        }
        treeSet.stream().forEach(integer -> System.out.println(" " + integer));
    }
}
