package transferobject;

/*
Student Name: Jadepat Chernsonthi
Student Number: 041074866
Course & Section #: 23S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * The PeerTutor class represents a peer tutor transfer object.
 * It encapsulates information about a peer tutor, such as their ID, last name, and first name.
 * 
 * Usage:
 * PeerTutor tutor = new PeerTutor();
 * tutor.setPeerTutorID(123);
 * tutor.setLastName("Smith");
 * tutor.setFirstName("John");
 * 
 * @author Jadepat
 */
public class PeerTutor {

    // Here are the fields for a peer tutor.
    private int peerTutorID;
    private String lastName;
    private String firstName;

    // TODO:  Add the necessary getters and setters.
    /**
     * Retrieves the peer tutor's ID.
     * 
     * @return The peer tutor's ID.
     */
    public int getPeerTutorID() {
        return peerTutorID;
    }

    /**
     * Sets the peer tutor's ID.
     * 
     * @param peerTutorID The peer tutor's ID to set.
     */
    public void setPeerTutorID(int peerTutorID) {
        this.peerTutorID = peerTutorID;
    }
    
    /**
     * Retrieves the peer tutor's last name.
     * 
     * @return The peer tutor's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the peer tutor's last name.
     * 
     * @param lastName The peer tutor's last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the peer tutor's first name.
     * 
     * @return The peer tutor's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the peer tutor's first name.
     * 
     * @param firstName The peer tutor's first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
