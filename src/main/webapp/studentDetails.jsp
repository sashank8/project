<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.List" %>
<%@ page import="com.abc.student.dao.Student" %>
<%@ page import="com.abc.student.services.authenticateUsers" %>
<%@ page import="com.abc.student.dao.AuthAdmin" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>
        <h1>Student Details</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Registration Number</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Attendance</th>
                    <th>Percentage</th>
                    <th>Branch</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterate over student records and display them in the table -->
                <% 
                 List<Student> students = (List<Student>) request.getAttribute("students");
                %>
                <% for (Student student : students) { %>
                    <tr>
                        <td><%= student.getRegistrationNumber() %></td>
                        <td><%= student.getName() %></td>
                        <td><%= student.getEmail() %></td>
                        <td><%= student.getAttendance() %></td>
                        <td><%= student.getPercentage() %></td>
                        <td><%= student.getBranch() %></td>
                         <td>
                        <!-- Form to send delete request -->
                        <form action="deleteStudent" method="post">
                            <input type="hidden" name="registrationNumber" value="<%= student.getRegistrationNumber() %>">
                            <input type="submit" value="Delete">
                        </form>
                        <a href="editStudent.jsp?registrationNumber=<%= student.getRegistrationNumber() %>">Edit</a>
                    </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addStudent.jsp">Add Student</a>
        
</body>
</html>

