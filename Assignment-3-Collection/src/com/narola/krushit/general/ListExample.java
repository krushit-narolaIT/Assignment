package com.narola.krushit.general;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        ListExample example = new ListExample();
        System.out.println("========  ArrayList Operations  ==========");
        example.arrayListOperations();

        System.out.println("========  LinkedList Operations  ==========");
        example.linkedListOperations();

        System.out.println("========  Vector Operations  ==========");
        example.vectorOperations();
    }

    /**
     * for arraylist operations
     */
    public void arrayListOperations() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("USA");
        arrayList.add("Canada");
        arrayList.add("Germany");
        arrayList.add("USA");
        System.out.println("ArrayList: " + arrayList);

        // Set element at index 3
        try {
            arrayList.set(3, "India"); //if index is out of greater then size then it throw AIOBE
            System.out.println("After set() in ArrayList: " + arrayList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds while setting in ArrayList.");
        }

        System.out.println("Index of India in ArrayList: " + arrayList.indexOf("India"));

        arrayList.remove("USA");
        System.out.println("After removing USA from ArrayList: " + arrayList);

        try {
            System.out.println("Get element at Index 2: " + arrayList.get(2)); //same it might throw AIOBE
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds while getting from ArrayList.");
        }

        System.out.println("Is India present in list: " + arrayList.contains("India"));
    }

    /**
     * For linked list operations
     */
    public void linkedListOperations() {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("USA");
        linkedList.add("Canada");
        linkedList.add("Germany");
        linkedList.add("USA");
        linkedList.add("India");

        System.out.println("LinkedList: " + linkedList);

        // Add elements at specific positions
        linkedList.add(0, "Australia");
        System.out.println("'After adding at 0th position:: " + linkedList);

        linkedList.add(3, "France");
        System.out.println("After adding france at index 3: " + linkedList);

        // Remove elements
        linkedList.remove(2); // Remove element at index 2
        System.out.println("After removing element at index 2: " + linkedList);

        linkedList.remove("USA"); // Remove the first occurence of USA
        System.out.println("After removing 'USA': " + linkedList);

        // Retrieve elements
        System.out.println("First element: " + linkedList.get(0));
        System.out.println("Last element: " + linkedList.get(linkedList.size() - 1));

        // set new element at ind 2
        linkedList.set(2, "Spain");
        System.out.println("After set() ops element at index 2 with 'Spain': " + linkedList);

        // Check for presence of an element
        System.out.println("Is 'India' present in LinkedList: " + linkedList.contains("India"));
    }

    /**
     * for vector operations
     */
    public void vectorOperations() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);

        try {
            //remove element
            vector.remove(3);

            //insert element at pos 1
            vector.insertElementAt(10, 0);
            System.out.println("Vector after adding element at 0 " + vector);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds while getting from ArrayList.");
        }

        //get first element
        System.out.println("First element in Vector: " + vector.get(0));
    }
}
