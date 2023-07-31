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
 * The Course class represents a course transfer object.
 * It encapsulates information about a course, such as its code, name, and description.
 * 
 * Usage:
 * Course course = new Course();
 * course.setCourseCode("CST8288");
 * course.setCourseName("Mobile Development");
 * course.setDescription("This course covers the development of mobile applications.");
 * 
 * @author Jadepat
 */
public class Course {

    private String courseCode;
    private String courseName;
    private String description;

    /**
     * Retrieves the course code.
     * 
     * @return The course code.
     */

    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code.
     * 
     * @param courseCode The course code to set.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Retrieves the course name.
     * 
     * @return The course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     * 
     * @param courseName The course name to set.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Retrieves the course description.
     * 
     * @return The course description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the course description.
     * 
     * @param description The course description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
