package com.studentSystem;

import static com.studentSystem.Main.studentList;

public class ListAllStudents {

    public static void listAllStudents() {
        if(studentList.isEmpty()) {
            System.err.println("Student List is Empty");
        } else {
            System.out.println("************* All Registered Students *************");
            for(Student student : studentList) {
                System.out.println(student);
            }
            System.out.println("****************************************************");
        }
    }
}
