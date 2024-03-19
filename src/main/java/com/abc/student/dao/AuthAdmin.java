package com.abc.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abc.student.util.DBUtil;

public class AuthAdmin {
	// String Auth_Query="select 1 from adminusers where username=? and password=?;";
	DBUtil db = new DBUtil();
	public boolean authenticateAdmin(String username,String password)throws SQLException
	{
		String Auth_Query="select 1 from adminusers where username='"+username+"' and password='"+password+"';";
		//String Auth_Query="select 1 from adminusers where username=? and password=?;";
        boolean isAdmin = false;
        
        try (Connection con = db.getDBConn();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(Auth_Query)) {
               isAdmin = rs.next(); // If any row is returned, the admin is authenticated
           }
           
           catch (ClassNotFoundException  e) {
               e.printStackTrace();
               // Handle exception
           }

           return isAdmin;
       }
	public boolean authenticateStaff(String username,String password)throws SQLException
	{
		String Staff_Query="select 1 from staffusers where username='"+username+"' and password='"+password+"';";
		//String Auth_Query="select 1 from adminusers where username=? and password=?;";
        boolean isStaff = false;
        
        try (Connection con = db.getDBConn();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(Staff_Query)) {
               isStaff = rs.next(); // If any row is returned, the admin is authenticated
           }
           
           catch (ClassNotFoundException  e) {
               e.printStackTrace();
               // Handle exception
           }

           return isStaff;
       }
	 /*public boolean authenticateAdmin(String username, String password) throws SQLException {
	        String Auth_Query = "SELECT 1 FROM adminusers WHERE username=? AND password=?";
	        boolean isAdmin = false;
	        
	        try (Connection con = db.getDBConn();
	             PreparedStatement pstmt = con.prepareStatement(Auth_Query)) {
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);
	            
	            try (ResultSet rs = pstmt.executeQuery()) {
	                isAdmin = rs.next(); // If any row is returned, the admin is authenticated
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }

	        return isAdmin;
	    }*/
	public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM studentdetails";
        
        try (Connection con = db.getDBConn();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String registrationNumber = rs.getString("registration_number");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int attendance = rs.getInt("attendance");
                int percentage = rs.getInt("percentage");
                String branch = rs.getString("branch");
                
                Student student = new Student(registrationNumber, name, email, attendance, percentage, branch);
                students.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        for (Student student : students) {
            System.out.println("Student: " + student.getRegistrationNumber() + ", " + student.getName() + ", " + student.getEmail() + ", " + student.getAttendance() + ", " + student.getPercentage() + ", " + student.getBranch());
        }
        
        return students;
    }
	public boolean authenticateStudent(String username, String password) throws SQLException {
        String studQuery = "SELECT 1 FROM studentusers WHERE username='" + username + "' AND password='" + password + "'";
        ResultSet res;
        int value = 0;
        try {
            Connection con = db.getDBConn();
            Statement stmt = con.createStatement();
            res = stmt.executeQuery(studQuery);
            while (res.next()) {
                value = res.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return value == 1;
    }

	/*public boolean authenticateStudent(String username, String password) throws SQLException {
	    String studQuery = "SELECT 1 FROM studentusers WHERE username=? AND password=?";
	    ResultSet res;
	    int value = 0;
	    try {
	        Connection con = db.getDBConn();
	        PreparedStatement ps = con.prepareStatement(studQuery);
	        ps.setString(1, username);
	        ps.setString(2, password);
	        res = ps.executeQuery();
	        while (res.next()) {
	            value = res.getInt(1);
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return value == 1;
	}*/

	
	public boolean checkStudentIfExist(String regNo)throws SQLException
	{
		String Check_Query="Select 1 from studentdetails where registration_number = '" + regNo + "' ";
		int value=0;
		try {
    		Connection con = db.getDBConn();
    		Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(Check_Query);
			while(result.next()) {
				value=result.getInt("1");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(value==1)
		{
			return true;
		}
		return false;
		
	}
	public boolean deleteStudent(String registrationNumber) throws SQLException {
        String deleteQuery = "DELETE FROM studentdetails WHERE registration_number = ?";
        try (Connection con = db.getDBConn();
             PreparedStatement ps = con.prepareStatement(deleteQuery)) {
            ps.setString(1, registrationNumber);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to delete student: " + e.getMessage());
        }
    }
	public boolean updateStudent(String registrationNumber, String name, String email, int attendance, int percentage, String branch) throws SQLException {
	    String updateQuery = "UPDATE studentdetails SET name=?, email=?, attendance=?, percentage=?, branch=? WHERE registration_number=?";
	    try (Connection con = db.getDBConn();
	         PreparedStatement ps = con.prepareStatement(updateQuery)) {
	        ps.setString(1, name);
	        ps.setString(2, email);
	        ps.setInt(3, attendance);
	        ps.setInt(4, percentage);
	        ps.setString(5, branch);
	        ps.setString(6, registrationNumber);

	        int rowsAffected = ps.executeUpdate();
	        return rowsAffected > 0;
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        throw new SQLException("Failed to update student: " + e.getMessage()); // Or handle it differently based on your application's needs
	    }
	}

	
}
