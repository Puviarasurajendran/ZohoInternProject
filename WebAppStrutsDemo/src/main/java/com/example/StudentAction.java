
package com.example;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.Student;

public class StudentAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private Student student;
    private List<Student> studentList = new ArrayList<>();
    
    public StudentAction() {
    	studentList = new ArrayList<>();
        studentList.add(new Student(1, "John Doe", 20));
        studentList.add(new Student(2, "Jane Smith", 22));
        studentList.add(new Student(3, "Michael Johnson", 21));
    }

    // GET /student/getStudent?id=1
    public String getStudentById() {
        
            	this.student = studentList.stream()
                        .filter(student -> student.getId() == id)
                        .findFirst()
                        .orElse(null);
            	         System.out.println(student);
             if(student==null) return ERROR;
             return SUCCESS;
    }

    // GET /student/getAllStudents
    public String getAllStudents() {
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
