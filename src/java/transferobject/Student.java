/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferobject;

/*
Student Name: Jadepat Chernsonthi
Student Number: 041074866
Course & Section #: 23S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * The Student class represents a student transfer object.
 * It encapsulates information about a student, such as their ID, last name, and first name.
 * 
 * Usage:
 * Student student = new Student();
 * student.setStudentID(123);
 * student.setLastName("Smith");
 * student.setFirstName("John");
 * 
 * @author Jadepat
 */
public class Student {

    private int studentID;
    private String lastName;
    private String firstName;

    /**
     * Retrieves the student's ID.
     * 
     * @return The student's ID.
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Sets the student's ID.
     * 
     * @param studentID The student's ID to set.
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Retrieves the student's last name.
     * 
     * @return The student's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     * 
     * @param lastName The student's last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the student's first name.
     * 
     * @return The student's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     * 
     * @param firstName The student's first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
