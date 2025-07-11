package com.studentSystem;

import java.util.Scanner;

import static com.studentSystem.Main.studentList;
import static com.studentSystem.Main.verifyStudentID;

public class RemoveStudentById {

    public static void removeStudentById(Scanner sc) {
        System.out.println("Enter Student ID: ");
        String studentId = sc.next();
        if(verifyStudentID(studentId)) {
            System.out.println("Are you sure you want to remove the student with ID " + studentId + "? (Yes/No)");
            String decision = sc.next();
            if(decision.equalsIgnoreCase("Yes")) {
                boolean removed = studentList.removeIf(s -> s.getStudentId().equalsIgnoreCase(studentId));
                if (removed) {
                    System.out.println("Student with ID " + studentId + " has been removed successfully.");
                } else {
                    System.err.println("Student with ID " + studentId + " not found!");
                }
            } else {
                System.out.println("Student removal Process Aborted.");
            }

        }
    }
}
