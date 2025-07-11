package com.studentSystem;

import java.util.Scanner;

import static com.studentSystem.Main.studentList;
import static com.studentSystem.Main.verifyStudentID;

public class EnrollCourse {

    public static void enrollInCourseById(Scanner sc) {
        System.out.println("Enter Student ID: ");
        String studentId = sc.next();
        if(verifyStudentID(studentId)) {
            System.out.println("Enter Course Name to Enroll:");
            String courseName = sc.next();
            studentList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst().ifPresent(student -> student.enrollCourse(courseName));
            while(true) {
                System.out.print("Do you wish to enroll in another course? (Yes/No): ");
                String decision = sc.next();
                if(decision.equalsIgnoreCase("Yes")) {
                    System.out.print("Enter Course Name to Enroll: ");
                    String courseNameToEnroll = sc.next();
                    studentList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                            .findFirst().ifPresent(student -> student.enrollCourse(courseNameToEnroll));
                } else {
                    System.out.println("Exiting Course Enrollment");
                    break;
                }
            }
        }
    }
}
