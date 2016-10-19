import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SearchDoctor
 */
@WebServlet("/SearchDoctor")
public class SearchDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement preparedStatement1;
	ResultSet rset = null;
	public List<Integer> doctoridList = new ArrayList<Integer>();
	public List<String> firstnameList = new ArrayList<String>();
	public List<String> lastnameList = new ArrayList<String>();
	public List<String> specialityList = new ArrayList<String>();
	public List<String> sexList = new ArrayList<String>();
	public List<String> emailidList = new ArrayList<String>();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Connection con = ConnectionManager.getConnection();
		
		String queryString = "select * "
				+ "from doctors " + "where speciality = ?";
		
		try {
			
			preparedStatement1 = (PreparedStatement) con.prepareStatement(queryString);
			preparedStatement1.setString(1, request.getParameter("speciality"));
			
			rset = preparedStatement1.executeQuery();
			doctoridList.clear();
			firstnameList.clear();
			lastnameList.clear();
			specialityList.clear();
			sexList.clear();
			emailidList.clear();

			while (rset.next()) {
				doctoridList.add(rset.getInt(1));
				firstnameList.add(rset.getString(2));
				lastnameList.add(rset.getString(3));
				specialityList.add(rset.getString(4));				
				sexList.add(rset.getString(5));
				emailidList.add(rset.getString(6));
			}
			
			preparedStatement1.close();

			rset.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("doctoridList", doctoridList);
		request.setAttribute("firstnameList", firstnameList);
		request.setAttribute("lastnameList", lastnameList);
		request.setAttribute("specialityList", specialityList);
		request.setAttribute("sexList", sexList);
		request.setAttribute("emailidList", emailidList);
		request.getRequestDispatcher("/DoctorsList.jsp").forward(request, response);
	}
	
}
