<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoctorsList</title>
</head>
<body>
	<CENTER>
		<TABLE BORDER=5>
			<TR>
				<TH CLASS="TITLE">Welcome to JPHospital</TH>
			</TR>
			<TR>
				<TD>Hello  <%=session.getAttribute("uname") %></TD>
			</TR>
		</TABLE>
		<BR>
	</CENTER>
	<LEFT>
	 <P><a href="SearchDoctor.jsp">Search Doctor</a></P>
                <P><a href="ViewAppointments.jsp">View Appointments</a></P>
                <P><a href="MyProfile.jsp">View MyProfile</a></P>
                <P><form method="post" action="/HealthCareProject/Logout"><button type="submit" name="logout">Logout</button></form> </P>
	</LEFT>

<sql:setDataSource var="localdb" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/completedatabase"
     user="root"  password="root123"/>

<sql:query dataSource="${localdb}" var="rset">select * from appointments where patientid = <%= session.getAttribute("userid") %>;</sql:query>

	
	
		<CENTER>
			<table border="1">
				<tr>
					<th>Doctor ID</th>
					<th>Date</th>
					<th>Time</th>
					
				</tr>
				<c:forEach var="row" items="${rset.rows}">
				
				<tr>
					<td><c:out value="${row.doctorid}"/></td>
					<td><c:out value="${row.date}"/></td>
					<td><c:out value="${row.time}"/></td>
					
					
				</tr>
				</c:forEach>
			</table>
			

			</CENTER>
	
</body>
</html>