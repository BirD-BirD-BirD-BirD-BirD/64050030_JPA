/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 64050030_Kitipum Nornua
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create student object
        Student student1 = new Student(1,"John",new BigDecimal(String.valueOf(3.07)));
        Student student2 = new Student(2,"Mary",new BigDecimal(String.valueOf(3.67)));
        Student student3 = new Student(3,"Kevin",new BigDecimal(String.valueOf(3.26)));
        Student student4 = new Student(4,"Jane",new BigDecimal(String.valueOf(4.00)));
        
        //add student to STUDENT TABLE
        StudentTable.insertStudent(student1);
        StudentTable.insertStudent(student2);
        StudentTable.insertStudent(student3);
        StudentTable.insertStudent(student4);
        
        //update student information
        update(1, "Johnny", new BigDecimal(String.valueOf(3.17)));
        update(2, "Maryne", new BigDecimal(String.valueOf(3.77)));
        update(3, "Kaine", new BigDecimal(String.valueOf(3.36)));
        update(4, "Jany", new BigDecimal(String.valueOf(4.00)));
        
        //delete student
        delete(4);
        
        //Show by student ID
        showById(1);
        
        //Show by student Name
        Student student5 = new Student(5, "Johnny", new BigDecimal(String.valueOf(3.45)));
        StudentTable.insertStudent(student5);
        showByName("Johnny");
                
        List<Student> studentList = StudentTable.findAllStudent();
        printAllStudent(studentList);
    }
    
    public static void printAllStudent(List<Student> studentList) {
        for(Student student : studentList) {
           System.out.print(student.getId() + " ");
           System.out.print(student.getName() + " ");
           System.out.println(student.getGpa() + " ");
       }
    }
    
    public static void update(Integer studentId, String studentName, BigDecimal Gpa){
        Student student;
        student = StudentTable.findStudentById(studentId);
        if(student != null){
            student.setName(studentName);
            student.setGpa(Gpa);
            StudentTable.updateStudent(student);
        }
    }
    
    public static void delete(Integer studentId){
        Student student;
        student = StudentTable.findStudentById(studentId);
        if(student != null){
            StudentTable.removeStudent(student);
        }
    }
    
    public static void showById(Integer studentId){
        Student student;
        student = (Student)StudentTable.findStudentById(studentId);
        System.out.println("Found student: " + student.getId() + " " + student.getName() + " " + student.getGpa());
    }
    
    public static void showByName(String studentName){
        List<Student> student;
        student = StudentTable.findStudentByName(studentName);
        printAllStudent(student);
    }
    
}
