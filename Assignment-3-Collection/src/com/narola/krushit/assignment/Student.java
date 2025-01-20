package com.narola.krushit.assignment;

public class Student {
    int id;
    String name;

    Student(int _id, String _name) {
        id = _id;
        name = _name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}