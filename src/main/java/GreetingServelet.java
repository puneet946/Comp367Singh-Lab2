

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServelet
 */
public class GreetingServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreetingServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Define the morning and afternoon time ranges
        LocalTime morningStart = LocalTime.of(6, 0);
        LocalTime afternoonStart = LocalTime.of(12, 0);

        // Determine the greeting based on the time of day
        String greeting;
        if (currentTime.isAfter(morningStart) && currentTime.isBefore(afternoonStart)) {
            greeting = "Good morning";
        } else {
            greeting = "Good afternoon";
        }

        // Replace "Your Name" with your actual name
        String name = "Puneet Singh"; // Change this to your name

        // Create the complete message
        String message = greeting + ", " + name + ", Welcome to COMP367";

        // Set the message as an attribute
        request.setAttribute("message", message);

        // Forward the request to the JSP
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
