package com.studentSystem;

import java.util.Scanner;

import static com.studentSystem.Main.studentList;

public class RegisterStudent {

    public static void registerStudent(Scanner sc) {
        System.out.print("Enter Student Name: ");
        String studentName = sc.next();

        System.out.print("Enter Student Age: ");
        int studentAge = sc.nextInt();

        System.out.print("Enter Student Id: ");
        String studentId = sc.next();

        Student newStudent = new Student(studentName, studentAge, studentId);

        while (true) {
            System.out.print("Do you wish to enroll in a course? (Yes/No): ");
            String decision = sc.next();
            if(decision.equalsIgnoreCase("Yes")) {
                System.out.print("Enter Course Name to Enroll: ");
                String courseName = sc.next();
                newStudent.enrollCourse(courseName);
            } else {
                System.out.println("Exiting Course Enrollment");
                break;
            }
        }

        newStudent.printStudentInfo();

        studentList.add(newStudent);
    }
}
