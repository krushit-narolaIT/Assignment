package com.narola.krushit.assignment;

import java.util.*;

public class ListAssignment {
    public static void main(String[] args) {
        ListAssignment listAssignment = new ListAssignment();
        System.out.println("==========  ArrayList Operations  ==========");
        listAssignment.arrayListOps();

        System.out.println("==========  LinkedList Operations  ==========");
        listAssignment.linkedListOps();

        System.out.println("==========   Assignment 2     ==============");
        listAssignment.sortingAndSerching();

        System.out.println("==========   Assignment 3     ==============");
        listAssignment.handlingDuplicates();

        System.out.println("==========   Assignment 4     ==============");
        listAssignment.coversion();
    }

    /** Assignment 1.1: Basic List Operations
     * 1. Create a program to:
     * ○ Add elements to a List.
     * ○ Retrieve an element by index.
     * ○ Iterate over the List using:
     *   ■ for loop
     *   ■ Enhanced for loop
     *   ■ Iterator
     *   ■ Stream
     * ○ Remove elements by:
     *   ■ Index
     *   ■ Value
     * 2. Use ArrayList for the above tasks
     */
    public void arrayListOps() {
        //assignment 1
        List<String> arrayList = new ArrayList<>();

        //Add elements to a List.
        arrayList.add("USA");
        arrayList.add("Canada");
        arrayList.add("Germany");
        arrayList.add("USA"); // allow duplicates
        System.out.println("ArrayList: " + arrayList);

        //Retrieve an element by index.
        try {
            System.out.println("Get element at Index 2: " + arrayList.get(2)); //same it might throw AIOBE
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds while getting from ArrayList.");
        }

        // Iterate over the List using:
        //  ■ for loop
        //  ■ Enhanced for loop
        //  ■ Iterator
        //  ■ Stream

        //for loop
        System.out.print("Using for loop :: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(" " + arrayList.get(i));
        }

        //Enhanced for loop
        System.out.print("\nUsing Enhance for loop :: ");
        for (String str : arrayList)
            System.out.print(" " + str);

        //Iterator
        //hasnext() check is next element available in collection
        //next() increse counter
        System.out.print("\nUsing Iterator :: ");
        Iterator<String> itr = arrayList.iterator();
        while (itr.hasNext()) {
            System.out.print(" " + itr.next());
        }

        //Using Stream
        System.out.println("\nUsing Stream :: ");
        arrayList.stream().forEach(s -> System.out.print("" + s));

        //Remove elements by:
        //■ Index
        //■ Value

        //remove by index
        System.out.println("Remove element at index 3");
        arrayList.remove(1);
        System.out.println("After removing 1st index from ArrayList: " + arrayList);

        //remove by name
        System.out.println("Remove element USA");
        arrayList.remove("USA");
        System.out.println("After removing USA from ArrayList: " + arrayList);
    }

    /** Assignment 1.2: Basic List Operations
     * 1. Create a program to:
     * ○ Add elements to a List.
     * ○ Retrieve an element by index.
     * ○ Iterate over the List using:
     *   ■ for loop
     *   ■ Enhanced for loop
     *   ■ Iterator
     *   ■ Stream
     * ○ Remove elements by:
     *   ■ Index
     *   ■ Value
     * 2. Use LinkedList for the above tasks
     */
    public void linkedListOps() {
        // Assignment 1: Basic LinkedList Operations
        List<String> linkedList = new LinkedList<>();

        // Add elements to a List.
        linkedList.add("USA");
        linkedList.add("Canada");
        linkedList.add("Germany");
        linkedList.add("USA"); // allow duplicates
        System.out.println("LinkedList: " + linkedList);

        // Retrieve an element by index.
        try {
            System.out.println("Get element at Index 2: " + linkedList.get(2)); // may throw IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds while getting from LinkedList.");
        }

        /*
         Iterate over the List using:
            ■ for loop
            ■ Enhanced for loop
            ■ Iterator
            ■ Stream
         */

        // for loop
        System.out.print("Using for loop :: ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(" " + linkedList.get(i));
        }

        // Enhanced for loop
        System.out.print("\nUsing Enhanced for loop :: ");
        for (String str : linkedList)
            System.out.print(" " + str);

        // Iterator
        System.out.print("\nUsing Iterator :: ");
        Iterator<String> itr = linkedList.iterator();
        while (itr.hasNext()) {
            System.out.print(" " + itr.next());
        }

        // Using Stream
        System.out.println("\nUsing Stream :: ");
        linkedList.stream().forEach(s -> System.out.print(" " + s));

        /* Remove elements by:
             ■ Index
             ■ Value
         */

        // by index
        System.out.println("\nRemove element at index 1");
        linkedList.remove(1);
        System.out.println("After removing 1st index from LinkedList: " + linkedList);

        System.out.println("Remove element USA");
        linkedList.remove("USA");
        System.out.println("After removing USA from LinkedList: " + linkedList);
    }

    /**
     * Assignment 2: Sorting and Searching
     * ● Write a program to:
     * ○ Sort a list of student names using Collections.sort.
     * ○ Search for a name using Collections.binarySearch.
     */
    public void sortingAndSerching(){
        // Assignment 2: Sorting and Searching
        Student s1 = new Student(1, "Krushit");
        Student s2 = new Student(2, "Sujal");
        Student s3 = new Student(3, "Ami");

        List<Student> studentList = new LinkedList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        Collections.sort(studentList, (a, b) -> a.name.compareTo(b.name));

        System.out.println("Sorted List of Students :: " + studentList);

        // Search for a name using Collections.binarySearch.
        // Uncommenting below would need Comparable<Student> implementation in Student
         int index = Collections.binarySearch(studentList, s2, (a, b) -> a.name.compareTo(b.name));
         System.out.println("Found Sujal at index: " + index);
    }

    /**
     * Assignment 3: Handling Duplicates
     * ● Write a program to count the frequency of duplicate elements in a List using
     * Collections.frequency.
     */
    public void handlingDuplicates(){
        List<String> arrayList = new ArrayList<>();

        arrayList.add("USA");
        arrayList.add("Canada");
        arrayList.add("Germany");
        arrayList.add("USA");
        arrayList.add("India");
        arrayList.add("USA");

        int countIndia = Collections.frequency(arrayList, "USA");
        System.out.println("Frequency of India in arraylist:: " + countIndia);
    }

    /**
     * Assignment 4: Convert List to Array and Vice Versa
     * ● Convert an array of integers into a List and back to an array. Print the results
     */
    public void coversion(){
        List<String> linkedList = new LinkedList<>();
        // Add elements to a List.
        linkedList.add("USA");
        linkedList.add("Canada");
        linkedList.add("Germany");
        linkedList.add("USA");
        System.out.println("LinkedList: " + linkedList);
        System.out.println("=== Converting LinkedList to Array ===");
        Object[] strArr = linkedList.toArray();
        String[] strArr1 = linkedList.toArray(new String[linkedList.size()]);
        for (int i = 0; i < strArr.length; i++) {
            System.out.print(" " + strArr[i]);
        }

        List<String> list = List.of(strArr1);
        System.out.println("\nArray from LinkedList :: " + list);

        // Convert an array of integers into a List and back to an array. Print the results
        Integer[] intArr = {1, 2, 3, 4, 5};
        List<Integer> integerList = List.of(intArr);

        System.out.println("Integer List :: " + integerList);

        Object[] intArr2 = integerList.toArray();
        System.out.print("Integer array2 ::");
        for (Object integer : intArr2) {
            System.out.print(" " + integer);
        }
    }
}
