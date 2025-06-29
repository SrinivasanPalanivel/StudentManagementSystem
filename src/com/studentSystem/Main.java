package com.studentSystem;

import java.util.*;

public class Main {

    //ArrayList to Store Student Objects
    private static List<Student> studentList;
    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("********* Welcome to Student Management System *********");
        //ArrayList to Store Student Objects
        studentList = new ArrayList<>();
        sc = new Scanner(System.in);

        while (true) {
            System.out.println("********** Home Screen **********");
            System.out.println("Select an option:");
            System.out.println("1. Register Student");
            System.out.println("2. Find Student by ID");
            System.out.println("3. List all Student Information");
            System.out.println("4. List all Student Information in Sorted Order");
            System.out.println("5. List all Available Courses");
            System.out.println("6. Exit");

            int selectedOption = sc.nextInt();

            switch (selectedOption) {
                case 1:
                    registerStudent(sc);
                    break;
                case 2:
                    findStudentById(sc);
                    break;
                case 3:
                    listAllStudents();
                    break;
                case 4:
                    sortStudentData(sc);
                    break;
                case 5:
                    availableCourses();
                    break;
                case 6:
                    exit(sc);
                    break;

                default:
                    System.err.println("Invalid option selected. Enter value between 1 to 6");
            }
        }
    }

    private static void listAllStudents() {
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

    private static void registerStudent(Scanner sc) {
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

    private static void exit(Scanner sc) {
        System.out.println("Do you want to exit? (Yes/No): ");
        String decision = sc.next();
        if (decision.equalsIgnoreCase("Yes")) {
            System.out.println("Exiting the Student Management System. Goodbye!");
            System.exit(0);
        }
    }

    private static void findStudentById(Scanner sc) {
        System.out.println("Enter Student ID: ");
        String studentId = sc.next();
        findStudentById(studentId);
    }

    private static void sortStudentData(Scanner sc) {
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
            System.err.println(" Enter a valid Student ID");
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