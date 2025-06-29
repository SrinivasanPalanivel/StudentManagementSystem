package com.studentSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

    //ArrayList to Store Student Objects
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("********* Welcome to Student Management System *********");

        //ArrayList to Store Student Objects
        studentList = new ArrayList<>();

        Student s1 = new Student("Zake Rider", 20, "S-100");
        s1.enrollCourse("Java");
        //System.out.println(s1);
        //s1.printStudentInfo();

        Student s2 = new Student("Bobby Roger",30,"S-101");
        s2.enrollCourse("python");
        //System.out.println(s2);

        Student s3 = new Student("Maria Began",27,"S-102");
        s3.enrollCourse("C#");
        s3.enrollCourse("Devops");
        //System.out.println(s3);

        Student s4 = new Student("Shilpa Patil",25,"S-103");
        s4.enrollCourse("C#");
        s4.enrollCourse("Ruby");
        //System.out.println(s4);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        //System.out.println(studentList);

//        Student result = findStudentById("S-105");
//        System.out.println("Found Student: " + result);

        // Sort students by name
        sortStudentByName();
        sortStudentByAge();
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