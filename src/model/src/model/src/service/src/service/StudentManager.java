package service;

import java.util.*;
import model.Student;

public class StudentManager implements RecordActions {

    private Map<Integer, Student> students = new HashMap<>();

    @Override
    public void addStudent(Student s) {
        if (students.containsKey(s.rollNo)) {
            System.out.println("Duplicate Roll Number. Cannot add.");
            return;
        }
        students.put(s.rollNo, s);
        System.out.println("Student added.");
    }

    @Override
    public void deleteStudent(int rollNo) {
        if (students.remove(rollNo) != null)
            System.out.println("Student deleted.");
        else
            System.out.println("Roll number not found.");
    }

    @Override
    public void updateStudent(int rollNo, Student s) {
        if (students.containsKey(rollNo)) {
            students.put(rollNo, s);
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public Student searchStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void viewAllStudents() {
        for (Student s : students.values()) {
            s.displayInfo();
            System.out.println("-----------------------");
        }
    }
}
