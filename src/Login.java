

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


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement preparedStatement1;
	ResultSet rset = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = ConnectionManager.getConnection();
		
		String queryString = "select password, firstname, lastname, birthdate, sex, emailid "
				+ "from userlogin, users " + "where userlogin.userId = ? and users.id = ?";
		
		try {
			
			preparedStatement1 = (PreparedStatement) con.prepareStatement(queryString);
			preparedStatement1.setInt(1, Integer.parseInt(request.getParameter("uid")));
			preparedStatement1.setInt(2, Integer.parseInt(request.getParameter("uid")));
			System.out.println("Login QueryString: "+ queryString);
			rset = preparedStatement1.executeQuery();
			rset.next();
			System.out.println("Password: "+ rset.getString(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(rset.getString(1).equals(request.getParameter("pwd"))){
				request.getSession().setAttribute("userid", request.getParameter("uid"));
				request.getSession().setAttribute("uname", rset.getString(2).concat(" ").concat(rset.getString(3)));
				request.getSession().setAttribute("udob", rset.getString(4));
				System.out.println("DOB: "+ rset.getString(4));
				request.getSession().setAttribute("usex", rset.getString(5));
				System.out.println("Sex: "+ rset.getString(5));
				request.getSession().setAttribute("uemail", rset.getString(6));
				
				request.getRequestDispatcher("/Home.jsp").forward(request, response);
			}else{
				request.setAttribute("errorMessage", "Incorrect Username or Password");
				request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
