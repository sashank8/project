<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.Statement" %>
<%@ page import="com.abc.student.util.DBUtil, com.abc.student.dao.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
<center>
    <h2>Search Results</h2>

    <%-- Retrieve Parameters --%>
    <% String studentName = request.getParameter("studentName"); %>

    <%-- Perform SQL Query --%>
    <% 
        if (studentName != null && !studentName.isEmpty()) {
            DBUtil db = new DBUtil();
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                con = db.getDBConn();
                stmt = con.createStatement();
                
                // Construct the SQL query
                String sqlQuery = "SELECT * FROM studentdetails WHERE name = '" + studentName + "'";
                
                // Execute the SQL query
                rs = stmt.executeQuery(sqlQuery);
    %>
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
                    // Display Search Results
                    while (rs.next()) {
    %>
                        <tr>
                            <td><%= rs.getString("registration_number") %></td>
                            <td><%= rs.getString("name") %></td>
                            <td><%= rs.getString("email") %></td>
                            <td><%= rs.getInt("attendance") %></td>
                            <td><%= rs.getDouble("percentage") %></td>
                            <td><%= rs.getString("branch") %></td>
                        </tr>
    <% 
                    }
    %>
                </table>
    <% 
            } catch (Exception e) {
                e.printStackTrace();
                out.println("An error occurred while processing the search.");
            } finally {
                // Close resources
                // Handle resource closure
            }
        } else {
            out.println("No student name provided.");
        }
    %>
    </center>
</body>
</html>
