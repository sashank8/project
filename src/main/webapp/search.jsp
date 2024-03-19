<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Students</title>
</head>
<body>
    <h2>Search Students by Name</h2>
    <form action="searchResults.jsp" method="get">
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName" required>
        <button type="submit">Search</button>
    </form>
</body>
</html>
