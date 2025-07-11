package com.studentSystem;

import java.util.*;

public class Main {

    //ArrayList to Store Student Objects
    public static List<Student> studentList;
    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("********* Welcome to Student Management System *********");
        //ArrayList to Store Student Objects
        studentList = new ArrayList<>();

        //Default Student List
        Student s1 = new Student("John Doe", 20, "S-001");
        s1.enrollCourse("Java");
        s1.enrollCourse("Python");
        Student s2 = new Student("John Doe", 21, "S-002");
        s2.enrollCourse("JavaScript");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(new Student("Alice Johnson", 19, "S-003"));

        sc = new Scanner(System.in);

        while (true) {
            System.out.println("********** Home Screen **********");
            System.out.println("Select an option:");
            System.out.println("1. Register Student");
            System.out.println("2. Find Student by ID");
            System.out.println("3. List all Student Information");
            System.out.println("4. List all Student Information in Sorted Order");
            System.out.println("5. List all Available Courses");
            System.out.println("6. Enroll in a Course using Student ID");
            System.out.println("7. Remove Student By ID");
            System.out.println("8. Exit");

            int selectedOption = sc.nextInt();

            switch (selectedOption) {
                case 1:
                    RegisterStudent.registerStudent(sc);
                    break;
                case 2:
                    FindStudentById.findStudentById(sc);
                    break;
                case 3:
                    ListAllStudents.listAllStudents();
                    break;
                case 4:
                    SortStudentData.sortStudentData(sc);
                    break;
                case 5:
                    availableCourses();
                    break;
                case 6:
                    EnrollCourse.enrollInCourseById(sc);
                    break;
                case 7:
                    RemoveStudentById.removeStudentById(sc);
                    break;
                case 8:
                    exit(sc);
                    break;

                default:
                    System.err.println("Invalid option selected. Enter value between 1 to 8");
            }
        }
    }

    public static boolean verifyStudentID(String stuID) {
        boolean flag = false;
        try{
            if(studentList.stream().anyMatch(studentId -> studentId.getStudentId().equalsIgnoreCase(stuID))) {
                System.out.println("Student Available with ID: " + stuID);
                flag = true;
            } else {
                throw new RuntimeException();
            }
        } catch(RuntimeException e) {
            System.err.println("Student with ID " + stuID + " not found!!");
        }
        return flag;
    }

    private static void exit(Scanner sc) {
        System.out.println("Do you want to exit? (Yes/No): ");
        String decision = sc.next();
        if (decision.equalsIgnoreCase("Yes")) {
            System.out.println("Exiting the Student Management System. Goodbye!");
            System.exit(0);
        }
    }

    private static void availableCourses() {
        System.out.println("****************** Available Courses ******************");
        for(String course : Student.courseList()) {
            System.out.println(course);
        }
        System.out.println("*******************************************************");
    }
}