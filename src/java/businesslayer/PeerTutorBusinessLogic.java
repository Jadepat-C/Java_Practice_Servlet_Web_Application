package businesslayer;

import dataaccesslayer.PeerTutorDAO;
import dataaccesslayer.PeerTutorDAOImpl;
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
 * The PeerTutorBusinessLogic class handles the business logic for managing peer tutors.
 * It provides methods to check if a peer tutor is registered, validate a course code, check
 * if a peer tutor has taken a specific course, get the letter grade of a peer tutor for a specific
 * course, check if a course is already assigned to a peer tutor, assign a course to a peer tutor,
 * and retrieve a list of all peer tutors for a specific course.
 * 
 * Usage:
 * PeerTutorBusinessLogic logic = new PeerTutorBusinessLogic();
 * boolean isRegistered = logic.isPeerTutorRegistered(peerTutor);
 * boolean isValidCourse = logic.isCourseValid(courseCode);
 * boolean hasTakenCourse = logic.hasPeerTutorTakenCourse(peerTutor, courseCode);
 * String letterGrade = logic.getPeerTutorLetterGradeForCourse(peerTutor, courseCode);
 * boolean isCourseAssigned = logic.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode);
 * logic.assignCourseToPeerTutor(peerTutor, courseCode);
 * List<PeerTutor> tutorsForCourse = logic.getAllPeerTutorsForCourse(courseCode);
 * 
 * @author Jadepat
 */
public class PeerTutorBusinessLogic {

    private PeerTutorDAO peerTutorDAO = null;
    
    /**
     * Constructs a new instance of PeerTutorBusinessLogic.
     * Initializes the PeerTutorDAO implementation for data access.
     */
    public PeerTutorBusinessLogic() {
        // TODO:  Add your code here.  Need to instantiate a DAO object here.
        peerTutorDAO = new PeerTutorDAOImpl();
    }

    /**
     * Checks if a peer tutor is registered in the system.
     * 
     * @param peerTutor The peer tutor to check for registration.
     * @return true if the peer tutor is registered, false otherwise.
     */
    public boolean isPeerTutorRegistered(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isPeerTutorRegistered(peerTutor);
    }

    /**
     * Validates if a given course code is valid.
     * 
     * @param courseCode The course code to validate.
     * @return true if the course code is valid, false otherwise.
     */
    public boolean isCourseValid(String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isCourseValid(courseCode);
    }

    /**
     * Checks if a peer tutor has taken a specific course.
     * 
     * @param peerTutor The peer tutor to check.
     * @param courseCode The course code to check.
     * @return true if the peer tutor has taken the course, false otherwise.
     */
    public boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.hasPeerTutorTakenCourse(peerTutor, courseCode);
    }

    /**
     * Retrieves the letter grade of a peer tutor for a specific course.
     * 
     * @param peerTutor The peer tutor to retrieve the letter grade for.
     * @param courseCode The course code to retrieve the letter grade for.
     * @return The letter grade of the peer tutor for the specified course.
     */
    public String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getPeerTutorLetterGradeForCourse(peerTutor, courseCode);
    }

    /**
     * Checks if a course is already assigned to a peer tutor.
     * 
     * @param peerTutor The peer tutor to check for course assignment.
     * @param courseCode The course code to check for assignment.
     * @return true if the course is already assigned to the peer tutor, false otherwise.
     */
    public boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode);
    }

     /**
     * Assigns a course to a peer tutor.
     * 
     * @param peerTutor The peer tutor to assign the course to.
     * @param courseCode The course code to assign to the peer tutor.
     */
    public void assignCourseToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        peerTutorDAO.assignCourseToPeerTutor(peerTutor, courseCode);
    }

    /**
     * Retrieves a list of all peer tutors assigned to a specific course.
     * 
     * @param courseCode The course code to retrieve the peer tutors for.
     * @return A list of peer tutors assigned to the specified course.
     */
    public List<PeerTutor> getAllPeerTutorsForCourse(String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getAllPeerTutorsForCourse(courseCode);
    }

}
