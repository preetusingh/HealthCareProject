<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchDoctor</title>
</head>
<body>
	<CENTER>
		<TABLE BORDER=5>
			<TR>
				<TH CLASS="TITLE">Welcome to JPHospital</TH>
			</TR>
			<TR>
				<TD>Hello <%=session.getAttribute("uname") %></TD>
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
<form method="post" action="/HealthCareProject/SearchDoctor">
	<CENTER>
		<P>
				<select name="speciality">
					<option value="Select">Select Specialization</option>
					<option value="Dental">Dental</option>
					<option value="Gynaecologist">Gynaecologist</option>
					<option value="ENT_physician">ENT</option>
					<option value="orthopaedic_surgeon">Orthopaedic</option>
				</select>
			</P>
			<P>
				<button type="submit">Search</button>
			</P>

		
	</CENTER>
</form>
</body>
</html>