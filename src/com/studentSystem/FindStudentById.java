package com.studentSystem;

import java.util.Scanner;

import static com.studentSystem.Main.studentList;

public class FindStudentById {

    public static void findStudentById(Scanner sc) {
        System.out.println("Enter Student ID: ");
        String studentId = sc.next();
        findStudentById(studentId);
    }

    public static void findStudentById(String studentId) {
        Student result = null;
        try {
            result = studentList
                    .stream()
                    .filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Student Not Found"));
        } catch (RuntimeException e) {
            System.err.print("Student with ID " + studentId + " not found!!");
        }

        if(result != null) {
            result.printStudentInfo();
        } else {
            System.err.println("Enter a valid Student ID");
        }

    }

}
