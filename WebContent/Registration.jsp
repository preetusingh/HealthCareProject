<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<CENTER>
		<TABLE BORDER=5>
		
			<TR >
				<TH CLASS="TITLE">Registration</TH>
			</TR>
		</TABLE>
		
	</CENTER>
	<form method="post" action="/HealthCareProject/Register">
	<CENTER>	
		<div style="color: #FF0000;">${errorMessage}</div>	
			<P>
			
			Enter Enrollment ID:
			<input type="text" name="enrollid">
			
			</P>
			<P>
			
			Enter First Name:
			<input type="text" name="fname">
			
			</P>
			<P>
			
			Enter Last Name:
			<input type="text" name="lname">
			
			</P>
			<P>
			
			Enter Birthdate:
			<input type="date" name="dob">
			
			</P>
			<P>
			
			Enter Sex:
			<Select name="sex">
				<option value="Male">Male</option>
				<option value="Female">Female</option>
			</Select>
						
			</P>
			<P>
			
			Enter Email Id:
			<input type="text" name="email">
			
			</P>
			<P>
			
			Enter Password:
			<input type="password" name="pwd">
			
			</P>
			<P>
			
			ReEnter Password:
			<input type="password" name="repwd">
			
			</P>
		
		<button type="submit" name="register">Register</button>
	
</CENTER>
</form>
</body>
</html>