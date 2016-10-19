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



	<%
		if (request.getAttribute("doctoridList") != "") {
			List<Integer> doctorIdList = (List<Integer>) request.getAttribute("doctoridList");
			List<String> fNameList = (List<String>) request.getAttribute("firstnameList");
			List<String> lNameList = (List<String>) request.getAttribute("lastnameList");
			List<String> specialtyList = (List<String>) request.getAttribute("specialityList");
			List<String> sexList = (List<String>) request.getAttribute("sexList");
			List<String> emailidList = (List<String>) request.getAttribute("emailidList");
	%>
	<form method="post" action="/HealthCareProject/ScheduleAppointmnet.jsp">
		<CENTER>
			<table border="1">
				<tr>
					<th>Doctor ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Specialty</th>
					<th>Sex</th>
					<th>EmailId</th>
				</tr>
				<%
					for (int i = 0; i < doctorIdList.size(); i++) {
				%>
				<tr>
					<td><input type="radio" name="docid"
						value="<%=doctorIdList.get(i)%>"><%=doctorIdList.get(i)%></td>
					<td><%=fNameList.get(i)%></td>
					<td><%=lNameList.get(i)%></td>
					<td><%=specialtyList.get(i)%></td>
					<td><%=sexList.get(i)%></td>
					<td><%=emailidList.get(i)%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>

			<button type="submit">Schedule Appointment</button>
		</CENTER>
	</form>
</body>
</html>