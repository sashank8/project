<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Student</h1>
<form action="updateStudent" method="post">
    <%-- Display existing student details for editing --%>
    <label>Registration Number:</label>
    <input type="text" name="registrationNumber" value="<%= request.getParameter("registrationNumber") %>" readonly><br>
    <label>Name:</label>
    <input type="text" name="name" value="<%= request.getParameter("name") %>"><br>
    <label>Email:</label>
    <input type="text" name="email" value="<%= request.getParameter("email") %>"><br>
    <label>Attendance:</label>
    <input type="text" name="attendance" value="<%= request.getParameter("attendance") %>"><br>
    <label>Percentage:</label>
    <input type="text" name="percentage" value="<%= request.getParameter("percentage") %>"><br>
    <label>Branch:</label>
    <input type="text" name="branch" value="<%= request.getParameter("branch") %>"><br>
    <input type="submit" value="Update">
</form>

</body>
</html>