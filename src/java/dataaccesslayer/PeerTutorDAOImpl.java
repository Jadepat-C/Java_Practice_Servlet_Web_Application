package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobject.Course;
import transferobject.PeerTutor;
import transferobject.Student;
/*
Student Name: Jadepat Chernsonthi
Student Number: 041074866
Course & Section #: 23S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * The PeerTutorDaoImpl class implements the PeerTutorDao interface. It
 * provides the actual implementation for managing recipients in the database.
 *
 * Usage: PeerTutorDao peerTutorDao = new PeerTutorDaoImpl(); // Use the
 * implemented methods to manage recipients in the database
 *
 * @author Jadepat
 */
public class PeerTutorDAOImpl implements PeerTutorDAO {

    /**
     * Checks if a peer tutor is registered in the database.
     * 
     * @param peerTutor The PeerTutor object to check if registered.
     * @return true if the peer tutor is registered, false otherwise.
     */
    @Override
    public boolean isPeerTutorRegistered(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<PeerTutor> tutors = null;
        String firstName = peerTutor.getFirstName();
        String lastName = peerTutor.getLastName();
        boolean isRegistered = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT FirstName, LastName, PeerTutorID FROM peertutor WHERE FirstName = ? AND LastName = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
            tutors = new ArrayList<>();
            while (rs.next()) {
                PeerTutor tutor = new PeerTutor();
                tutor.setPeerTutorID(rs.getInt("PeerTutorID"));
                tutor.setFirstName(rs.getString("FirstName"));
                tutor.setLastName(rs.getString("Lastname"));
                tutors.add(tutor);
            }
            if (tutors.size() > 1) {
                System.err.println("There are more than 1 instance in the peertutor table");
            } else if (tutors.size() < 1) {
                isRegistered = false;
            } else {
                isRegistered = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return isRegistered;
    }

    /**
     * Validates if a given course code exists in the database.
     * 
     * @param courseCode The course code to validate.
     * @return true if the course code is valid, false otherwise.
     */
    @Override
    public boolean isCourseValid(String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course course = null;
        boolean isCourseValid = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT CourseCode, CourseName, CourseDescription FROM course WHERE CourseCode = ?");
            pstmt.setString(1, courseCode);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setCourseCode(rs.getString("CourseCode"));
                course.setCourseName(rs.getString("CourseName"));
                course.setDescription(rs.getString("CourseDescription"));
            }
            if (course != null) {
                isCourseValid = true;
            } else {
                isCourseValid = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return isCourseValid;
    }

    /**
     * Checks if a peer tutor has taken a specific course.
     * 
     * @param peerTutor The PeerTutor object to check.
     * @param courseCode The course code to check.
     * @return true if the peer tutor has taken the course, false otherwise.
     */
    @Override
    public boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course course = null;
        Student student = null;
        String firstName = peerTutor.getFirstName();
        String lastName = peerTutor.getLastName();
        boolean hasTakenCourse = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StudentID FROM student WHERE FirstName = ? AND LastName = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
            }
            pstmt = con.prepareStatement(
                    "SELECT Student_StudentID , Course_CourseCode FROM studentcourse WHERE Student_StudentID = ? AND Course_CourseCode = ?");
            pstmt.setInt(1, student.getStudentID());
            pstmt.setString(2, courseCode);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setCourseCode(rs.getString("Course_CourseCode"));
            }
            if (student != null && course != null) {
                hasTakenCourse = true;
            } else {
                hasTakenCourse = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return hasTakenCourse;
    }

    /**
     * Retrieves the letter grade of a peer tutor for a specific course.
     * 
     * @param peerTutor The PeerTutor object to retrieve the grade for.
     * @param courseCode The course code to retrieve the grade for.
     * @return The letter grade of the peer tutor for the specified course.
     */
    @Override
    public String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course course = null;
        PeerTutor tutor = null;
        Student student = null;
        String firstName = peerTutor.getFirstName();
        String lastName = peerTutor.getLastName();
        String grade = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StudentID FROM student WHERE FirstName = ? AND LastName = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
            }
            pstmt = con.prepareStatement(
                    "SELECT GradeCode FROM grade WHERE Student_StudentID = ? AND Course_CourseCode = ?");
            pstmt.setInt(1, student.getStudentID());
            pstmt.setString(2, courseCode);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                grade = rs.getString("GradeCode");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return grade;
    }

    /**
     * Checks if a course is already assigned to a peer tutor.
     * 
     * @param peerTutor The PeerTutor object to check.
     * @param courseCode The course code to check.
     * @return true if the course is already assigned to the peer tutor, false otherwise.
     */
    @Override
    public boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course course = null;
        PeerTutor tutor = null;
        String firstName = peerTutor.getFirstName();
        String lastName = peerTutor.getLastName();
        boolean isAssigned = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT PeerTutorID FROM peertutor WHERE FirstName = ? AND LastName = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                tutor = new PeerTutor();
                tutor.setPeerTutorID(rs.getInt("PeerTutorID"));
            }
            pstmt = con.prepareStatement(
                    "SELECT PeerTutor_PeerTutorID , Course_CourseCode FROM peertutorcourse WHERE PeerTutor_PeerTutorID = ? AND Course_CourseCode = ?");
            pstmt.setInt(1, tutor.getPeerTutorID());
            pstmt.setString(2, courseCode);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setCourseCode(rs.getString("Course_CourseCode"));
            }
            if (tutor != null && course != null) {
                isAssigned = true;
            } else {
                isAssigned = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return isAssigned;
    }

    /**
     * Assigns a course to a peer tutor in the database.
     * 
     * @param peerTutor The PeerTutor object to assign the course to.
     * @param courseCode The course code to assign.
     */
    @Override
    public void assignCourseToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course course = null;
        PeerTutor tutor = null;
        String firstName = peerTutor.getFirstName();
        String lastName = peerTutor.getLastName();
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT PeerTutorID FROM peertutor WHERE FirstName = ? AND LastName = ?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                tutor = new PeerTutor();
                tutor.setPeerTutorID(rs.getInt("PeerTutorID"));
            }
            pstmt = con.prepareStatement(
                    "INSERT INTO peertutorcourse VALUE (?,?)");
            pstmt.setInt(1, tutor.getPeerTutorID());
            pstmt.setString(2, courseCode);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Retrieves a list of all peer tutors for a specific course.
     * 
     * @param courseCode The course code to retrieve peer tutors for.
     * @return A list of PeerTutor objects for the specified course.
     */
    @Override
    public List<PeerTutor> getAllPeerTutorsForCourse(String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<PeerTutor> peerTutors = new ArrayList<>();
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT p.PeerTutorID, p.FirstName, p.LastName "
                    + "FROM peertutor p "
                    + "JOIN peertutorcourse pc ON p.PeerTutorID = pc.PeerTutor_PeerTutorID "
                    + "WHERE pc.Course_CourseCode = ?");
            pstmt.setString(1, courseCode);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                PeerTutor tutor = new PeerTutor();
                tutor.setPeerTutorID(rs.getInt("PeerTutorID"));
                tutor.setFirstName(rs.getString("FirstName"));
                tutor.setLastName(rs.getString("LastName"));
                peerTutors.add(tutor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return peerTutors;
    }

}
