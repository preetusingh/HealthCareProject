

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class RegisterVerify
 */
@WebServlet("/RegisterVerify")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement preparedStatement1;
	private PreparedStatement preparedStatement2;
	ResultSet rset = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("pwd").equals(request.getParameter("repwd"))){
		Connection con = ConnectionManager.getConnection();
		
		String queryString1 = "insert into users values(?, ?, ?, ?, ?, ? )";
		String queryString2 = "insert into userlogin values(?, ?)";
		
		try {
			
			preparedStatement1 = (PreparedStatement) con.prepareStatement(queryString1);
			preparedStatement1.setInt(1, Integer.parseInt(request.getParameter("enrollid")));
			preparedStatement1.setString(2, request.getParameter("fname"));
			preparedStatement1.setString(3, request.getParameter("lname"));
			preparedStatement1.setString(4, request.getParameter("dob"));
			preparedStatement1.setString(5, request.getParameter("sex"));
			preparedStatement1.setString(6, request.getParameter("email"));
			
			preparedStatement2 = (PreparedStatement) con.prepareStatement(queryString2);
			preparedStatement2.setInt(1, Integer.parseInt(request.getParameter("enrollid")));
			preparedStatement2.setString(2, request.getParameter("pwd"));
			
			int rows = preparedStatement1.executeUpdate();
			
			if(rows > 0){
				preparedStatement2.executeUpdate();
				request.getRequestDispatcher("/RegistrationSuccess.jsp").forward(request, response);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", "There was some issue with Registration, Please try again.");
			request.getRequestDispatcher("/Registration.jsp").forward(request, response);
		}
		
		}else{
			request.setAttribute("errorMessage", "Password Entry Mismatch");
			request.getRequestDispatcher("/Registration.jsp").forward(request, response);
			
		}
		
	}

}
