package viewlayer;

import businesslayer.PeerTutorBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobject.PeerTutor;

/*
Student Name: Jadepat Chernsonthi
Student Number: 041074866
Course & Section #: 23S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
 */
/**
 * The PeerTutorServlet class represents a servlet that handles requests related
 * to managing peer tutors. It processes HTTP GET and POST requests and responds
 * with an HTML page containing information about peer tutors and course
 * assignments. The servlet uses the PeerTutorBusinessLogic class to interact
 * with the database and perform business logic operations.
 *
 * Usage: To use this servlet, you can send HTTP GET or POST requests to it and
 * receive an HTML page as the response. The HTML page will contain information
 * about peer tutors and course assignments based on the provided request
 * parameters.
 *
 * Note: This servlet is responsible for composing the HTML response and using
 * the business logic object (PeerTutorBusinessLogic) to access the database and
 * perform necessary operations. It retrieves request parameters, instantiates a
 * PeerTutor object, and sets its fields as needed. The servlet uses Bootstrap
 * for styling and includes a warning function to display error messages in
 * JavaScript alerts.
 *
 * @author Jadepat
 */
public class PeerTutorServlet extends HttpServlet {

    private PeerTutor peerTutor = new PeerTutor();
    private String courseCode;
    private String errorMsg;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // TODO:  Add your code here.  Make sure to use try-catch or
        //        try-with-resources statement here.  Need to instantiate a
        //        PrintWriter object which is a resource.  You can use the
        //        PrintWriter object to compose the HTML response of this
        //        servlet.  Also, need to instantiate a PeerTutorBusinessLogic
        //        object here and use it to access the database by calling its
        //        appropriate methods.  As the servlet composes the HTML response,
        //        it should use the business logic object.  You should also
        //        retrieve the request parameters here and instantiate a PeerTutor
        //        object and set its fields as needed.  Use bgcolor="#FDF5E6" for
        //        the background color of the HTML response of this servlet.
        //        Please refer to the sample projects code in Week 9.
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            peerTutor.setFirstName(request.getParameter("firstname"));
            peerTutor.setLastName(request.getParameter("lastname"));
            courseCode = request.getParameter("coursecode");
            PeerTutorBusinessLogic logic = new PeerTutorBusinessLogic();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Peer Tutor Summary View</title>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            //import bootstrap CSS and JS
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\" crossorigin=\"anonymous\"></script>");
            //end bootstrap import
            //bg css
            out.println("<style>");
            out.println(".bg-all {background-color: #FDF5E6;}");
            out.println("</style>");
            //alert scrpit
            out.println("<script>");
            out.println("function warning(msg) {");
            out.println("alert(msg)");
            out.println("}");
            out.println("</script>");
            out.println("</head>");
            out.println("<body class=\"bg-all container-fluid\">");
            out.println("<h1 class=\"h1 pt-5 px-5\">Servlet PeerTutorServlet at " + request.getContextPath() + "</h1>");
            out.println("<div class=\"col-sm-6 mx-5\">");
            try {
                if (!logic.isPeerTutorRegistered(peerTutor)) {
                    errorMsg = "This person is not registered as a peer tutor";
                    out.println("<ul>");
                    out.println("<li><b>Last Name:</b> " + peerTutor.getLastName() + "</li>");
                    out.println("<li><b>First Name:</b> " + peerTutor.getFirstName() + "</li>");
                    out.println("</ul>");
                    out.println("<h4 class=\"h4 text-danger\"> Error: " + errorMsg + "</h4>");
                    out.println("<script> warning('" + errorMsg + "'); </script>");
                } else if (!logic.isCourseValid(courseCode)) {
                    errorMsg = "The course is not valid";
                    out.println("<ul>");
                    out.println("<li><b>Course Code:</b> " + courseCode + "</li>");
                    out.println("</ul>");
                    out.println("<h4 class=\"h4 text-danger\"> Error: " + errorMsg + "</h4>");
                    out.println("<script> warning('" + errorMsg + "'); </script>");
                } else if (!logic.hasPeerTutorTakenCourse(peerTutor, courseCode)) {
                    errorMsg = "Peer tutor has not taken the course";
                    out.println("<ul>");
                    out.println("<li><b>Last Name:</b> " + peerTutor.getLastName() + "</li>");
                    out.println("<li><b>First Name:</b> " + peerTutor.getFirstName() + "</li>");
                    out.println("<li><b>Course Code:</b> " + courseCode + "</li>");
                    out.println("</ul>");
                    out.println("<h4 class=\"h4 text-danger\"> Error: " + errorMsg + "</h4>");
                    out.println("<script> warning('" + errorMsg + "'); </script>");
                } else if (!logic.getPeerTutorLetterGradeForCourse(peerTutor, courseCode).contains("A")) {
                    errorMsg = "The letter grade peer tutor obatined is not sufficient";
                    out.println("<ul>");
                    out.println("<li><b>Last Name:</b> " + peerTutor.getLastName() + "</li>");
                    out.println("<li><b>First Name:</b> " + peerTutor.getFirstName() + "</li>");
                    out.println("<li><b>Course Code:</b> " + courseCode + "</li>");
                    out.println("</ul>");
                    out.println("<h4 class=\"h4 text-danger\"> Error: " + errorMsg + "</h4>");
                    out.println("<script> warning('" + errorMsg + "'); </script>");
                } else if (logic.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode)) {
                    errorMsg = "The peer tutor is already assigned to the course";
                    out.println("<li><b>Last Name:</b> " + peerTutor.getLastName() + "</li>");
                    out.println("<li><b>First Name:</b> " + peerTutor.getFirstName() + "</li>");
                    out.println("<li><b>Course Code:</b> " + courseCode + "</li>");
                    out.println("</ul>");
                    out.println("<h4 class=\"h4 text-danger\"> Error: " + errorMsg + "</h4>");
                    out.println("<script> warning('" + errorMsg + "'); </script>");
                } else {
                    try {
                        logic.assignCourseToPeerTutor(peerTutor, courseCode);
                        List<PeerTutor> peerTutors = logic.getAllPeerTutorsForCourse(courseCode);
                        out.println("<h3 class=\"h3\">Table of Peer Tutor for " + courseCode + "</h3>");
                        out.println("<div class=\"table-responsive\">");
                        out.println("<table class=\"table table-bordered mx-auto\">");
                        out.println("<tr>");
                        out.println("<td>Tutor ID</td>");
                        out.println("<td>Last Name</td>");
                        out.println("<td>First Name</td>");
                        out.println("</tr>");
                        for (PeerTutor tutor : peerTutors) {
                            out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                                    tutor.getPeerTutorID(), tutor.getLastName(), tutor.getFirstName());
                        }
                        out.println("</table>");
                        out.println("<h4 class=\"h4 text-success\">" + "New ccourse has been assigned to peer tutor" + "</h4>");
                        out.println("</div>");
                    } catch (Exception e) {
                        errorMsg = "There is an error occured. Please check with the application stacktrace";
                        out.println("<h4 class=\"h4 text-danger\"> Error: " + errorMsg + "</h4>");
                        out.println("<script> warning('" + errorMsg + "'); </script>");
                    }
                }
            } catch (Exception e) {
                errorMsg = "There is an error occured. Please check with the application stacktrace";
                out.println("<h4 class=\"h4 text-danger\"> Error: " + errorMsg + "</h4>");
                out.println("<script> warning('" + errorMsg + "'); </script>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
