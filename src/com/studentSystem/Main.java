package com.studentSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("********* Welcome to Student Management System *********");

        //ArrayList to Store Student Objects
        List<Student> studentList = new ArrayList<>();

        Student s1 = new Student("Zake Rider", 20, "S-100");
        s1.enrollCourse("Java");
        System.out.println(s1);
        //s1.printStudentInfo();

        Student s2 = new Student("Bobby Roger",30,"S-101");
        s2.enrollCourse("python");
        System.out.println(s2);

        Student s3 = new Student("Maria Began",27,"S-102");
        s3.enrollCourse("C#");
        s3.enrollCourse("Devops");
        System.out.println(s3);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        System.out.println(studentList);
    }
}