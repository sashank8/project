<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>
<center>
    <h2>Student Details</h2>
    <table border="1">
        <tr>
            <th>Registration Number</th>
            <th>Name</th>
            <th>Email</th>
            <th>Attendance</th>
            <th>Percentage</th>
            <th>Branch</th>
        </tr>
        <%
            String registrationNumber = request.getParameter("registrationNumber");
            if (registrationNumber != null && !registrationNumber.isEmpty()) {
                out.println("<tr>");
                out.println("<td>" + registrationNumber + "</td>");
                out.println("<td>" + request.getAttribute("name") + "</td>");
                out.println("<td>" + request.getAttribute("email") + "</td>");
                out.println("<td>" + request.getAttribute("attendance") + "</td>");
                out.println("<td>" + request.getAttribute("percentage") + "</td>");
                out.println("<td>" + request.getAttribute("branch") + "</td>");
                out.println("</tr>");
            } else {
                out.println("<tr>");
                out.println("<td colspan=\"6\">Invalid registration number</td>");
                out.println("</tr>");
            }
        %>
    </table>
    </center>
</body>
</html>
