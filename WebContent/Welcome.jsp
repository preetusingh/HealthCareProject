<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<CENTER>
		<TABLE BORDER=5>
			<TR>
				<TH CLASS="TITLE">Welcome to JPHospital</TH>
			</TR>
		</TABLE>
		<BR>
		<P>
		<form method="post" action="/HealthCareProject/Login">
			<div style="color: #FF0000;">${errorMessage}</div>
			<p>
				User Name: <input type="text" name="uid">
			</p>
			<p>
				Password: <input type="password" name="pwd">
			</p>
			<p>
				<button type="submit" name="Submit">Login</button>
				<button type="reset">Reset</button>
			</p>

			<p>
				New User? <a href="Registration.jsp">Register</a>
			</p>
		</form>
	</CENTER>
</body>
</html>