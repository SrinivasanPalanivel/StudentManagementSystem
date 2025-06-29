package com.studentSystem;

import java.util.*;

public class Main3 {

    //ArrayList to Store Student Objects
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("********* Welcome to Student Management System *********");

        //ArrayList to Store Student Objects
        studentList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = sc.next();
        System.out.print("Entered Student Name is: "+name);
    }

    public static void sortStudentByName() {
        // Using a lambda expression to create a Comparator for sorting by name
        Comparator<Student> studentNameComparator = Comparator.comparing(Student::getName);

        //Lambda expression solution
        //Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());

        /* //Basic Solution
        Comparator<Student> studentNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

         */

        Collections.sort(studentList, studentNameComparator);
        System.out.println(studentList);
    }

    public static void sortStudentByAge() {
        Comparator<Student> studentAgeComparator = Comparator.comparing(Student::getAge);

        Collections.sort(studentList, studentAgeComparator);
        System.out.println(studentList);
    }

    public static Student findStudentById(String studentId) {
        Student result = null;
        try {
            result = studentList
                    .stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Student Not Found"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found!!");
        }
        return result;
    }
}