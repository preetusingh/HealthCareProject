

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ScheduleAppointmnet
 */
@WebServlet("/ScheduleAppointmnet")
public class ScheduleAppointmnet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement preparedStatement1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAppointmnet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = ConnectionManager.getConnection();
		
		String queryString1 = "insert into appointments values(?, ?, ?, ? )";
				
		try {
			
			preparedStatement1 = (PreparedStatement) con.prepareStatement(queryString1);
			preparedStatement1.setInt(1, Integer.parseInt(request.getSession().getAttribute("userid").toString()));
			preparedStatement1.setString(2, request.getParameter("docid"));
			preparedStatement1.setString(3, request.getParameter("date"));
			preparedStatement1.setString(4, request.getParameter("time"));
									
			int rows = preparedStatement1.executeUpdate();
			
			if(rows > 0){
				request.getRequestDispatcher("/AppointmentSuccess.jsp").forward(request, response);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", "There was some issue with Scheduling Appointment, Please try again.");
			request.getRequestDispatcher("/ScheduleAppointmnet.jsp").forward(request, response);
		}
		
				
	}

}
