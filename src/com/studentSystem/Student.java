package com.studentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId) {
        if(validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<>(); // Initialize the courses list
        }
    }

    public void enrollCourse(String course) {
        if(courseList().stream().anyMatch(c -> c.equalsIgnoreCase(course))) {
            if(!courses.contains(course)) {
                courses.add(course);
                System.out.println("You have successfully enrolled to " + course);
            } else {
                System.err.println("Duplicate Entry!! You have already registered to the "+course+" course");
            }
        } else {
            System.err.println("Course not available!! Available courses are: "+courseList());
        }
    }

    public void printStudentInfo() {
        System.out.println("=============== Student Information ===============");
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("Enrolled Courses: " + courses);
    }

    public String toString() {
        return "Student Data [Name: " + name + ", Age: " + age + ", StudentID: " + studentId+", Courses: " + courses + "]";
    }

    //Validation Methods
    public boolean validateAge(int age) {
        if(age>=18 && age <=40) {
            return true;
        } else {
            System.err.println("Invalid Age!!! Student age must be between 18 to 40");
            return false;
        }
    }

    public boolean validateName(String name) {
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePattern.matcher(name);
        if(nameMatcher.matches()) {
            return true;
        } else {
            System.err.println("Invalid Name!!! Name must contain only letters and spaces");
            return false;
        }
    }

    public boolean validateStudentId(String studentId) {
        String studentIdRegex = "S-[0-9]+$";
        Pattern studentIdPattern = Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher  = studentIdPattern.matcher(studentId);
        if(studentIdMatcher.matches()) {
            return true;
        } else {
            System.err.println("Invalid ID!!! Student ID must contain only digits along with S-.. Eg:S-123");
            return false;
        }
    }

    public static List<String> courseList() {
        List<String> coursesList = new ArrayList<>();
        coursesList.add("Java");
        coursesList.add("Python");
        coursesList.add("C#");
        coursesList.add("DevOps");
        coursesList.add("Ruby");
        return coursesList;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getStudentId() {
        return studentId;
    }
    public List<String> getCourses() {
        return courses;
    }
}
