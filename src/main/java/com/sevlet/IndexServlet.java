import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve all submissions from the LoggyService
        LoggyService loggyService = new LoggyService();
        List<Submission> submissions = loggyService.getAllSubmissions();

        // Close the connection after retrieving the submissions
        loggyService.closeConnection();

        // Set the list of submissions as an attribute in the request
        request.setAttribute("submissions", submissions);

        // Forward the request to the index.jsp to display the submissions
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
