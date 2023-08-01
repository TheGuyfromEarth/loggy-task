import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/submit_post")
public class SubmitPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Part contentPart = request.getPart("content");

        // Validation and processing of the file upload can go here...

        // Create a new submission object
        Submission submission = new Submission(title, description, contentType, thumbnailUrl);

        // Save the submission using the LoggyService
        LoggyService loggyService = new LoggyService();
        loggyService.addSubmission(submission);

        // Close the connection after the submission has been added
        loggyService.closeConnection();

        // Redirect back to the index.jsp after submitting the post
        response.sendRedirect("index.jsp");
    }
}
