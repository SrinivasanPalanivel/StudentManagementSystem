package com.studentSystem;

import java.util.Comparator;
import java.util.Scanner;

import static com.studentSystem.Main.studentList;

public class SortStudentData {

    public static void sortStudentData(Scanner sc) {
        if(studentList.isEmpty()) {
            System.err.println("Student List is Empty");
        } else {
            System.out.println("Do you want to sort students by Name or Age? (Name/Age): ");
            String sortOption = sc.next();
            if(sortOption.equalsIgnoreCase("Name")) {
                System.out.println("*********** Sorting Students by Name ***********");
                sortStudentByName();
                System.out.println("************************************************");
            } else if(sortOption.equalsIgnoreCase("Age")) {
                System.out.println("*********** Sorting Students by Age ***********");
                sortStudentByAge();
                System.out.println("************************************************");
            } else {
                System.err.println("Invalid option selected. Please enter 'Name' or 'Age'.");
            }
        }

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

        studentList.sort(studentNameComparator);
        for(Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void sortStudentByAge() {
        Comparator<Student> studentAgeComparator = Comparator.comparing(Student::getAge);

        studentList.sort(studentAgeComparator);
        for(Student student : studentList) {
            System.out.println(student);
        }
    }
}
