package dataaccesslayer;

import java.util.List;
import transferobject.PeerTutor;
/*
Student Name: Jadepat Chernsonthi
Student Number: 041074866
Course & Section #: 23S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * The PeerTutorDAO interface defines the operations for managing peer tutors in the database.
 * Implementations of this interface provide methods to check if a peer tutor is registered,
 * validate a course code, check if a peer tutor has taken a specific course, get the letter grade
 * of a peer tutor for a specific course, check if a course is already assigned to a peer tutor,
 * assign a course to a peer tutor, and retrieve a list of all peer tutors for a specific course.
 * Each method corresponds to a specific database operation related to peer tutors.
 * 
 * Note: The implementation of this interface should handle database connections and transactions.
 * 
 * Usage:
 * PeerTutorDAO peerTutorDAO = new PeerTutorDAOImpl();
 * boolean isRegistered = peerTutorDAO.isPeerTutorRegistered(peerTutor);
 * boolean isValidCourse = peerTutorDAO.isCourseValid(courseCode);
 * boolean hasTakenCourse = peerTutorDAO.hasPeerTutorTakenCourse(peerTutor, courseCode);
 * String letterGrade = peerTutorDAO.getPeerTutorLetterGradeForCourse(peerTutor, courseCode);
 * boolean isCourseAssigned = peerTutorDAO.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode);
 * peerTutorDAO.assignCourseToPeerTutor(peerTutor, courseCode);
 * List<PeerTutor> tutorsForCourse = peerTutorDAO.getAllPeerTutorsForCourse(courseCode);
 * 
 * @author Jadepat
 */
public interface PeerTutorDAO {
    /**
     * Checks if a peer tutor is registered in the database.
     * 
     * @param peerTutor The PeerTutor object to check if registered.
     * @return true if the peer tutor is registered, false otherwise.
     */
    boolean isPeerTutorRegistered(PeerTutor peerTutor);
    
    /**
     * Validates if a given course code exists in the database.
     * 
     * @param courseCode The course code to validate.
     * @return true if the course code is valid, false otherwise.
     */
    boolean isCourseValid(String courseCode);
    
    /**
     * Checks if a peer tutor has taken a specific course.
     * 
     * @param peerTutor The PeerTutor object to check.
     * @param courseCode The course code to check.
     * @return true if the peer tutor has taken the course, false otherwise.
     */
    boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode);
    
    /**
     * Retrieves the letter grade of a peer tutor for a specific course.
     * 
     * @param peerTutor The PeerTutor object to retrieve the grade for.
     * @param courseCode The course code to retrieve the grade for.
     * @return The letter grade of the peer tutor for the specified course.
     */
    String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode);
    
    /**
     * Checks if a course is already assigned to a peer tutor.
     * 
     * @param peerTutor The PeerTutor object to check.
     * @param courseCode The course code to check.
     * @return true if the course is already assigned to the peer tutor, false otherwise.
     */
    boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode);
    
    /**
     * Assigns a course to a peer tutor in the database.
     * 
     * @param peerTutor The PeerTutor object to assign the course to.
     * @param courseCode The course code to assign.
     */
    void assignCourseToPeerTutor(PeerTutor peerTutor, String courseCOde);
    
    /**
     * Retrieves a list of all peer tutors for a specific course.
     * 
     * @param courseCode The course code to retrieve peer tutors for.
     * @return A list of PeerTutor objects for the specified course.
     */
    List<PeerTutor> getAllPeerTutorsForCourse(String courseCode);
}

