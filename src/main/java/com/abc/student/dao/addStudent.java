package com.abc.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.student.util.DBUtil;

public class addStudent {
	
    DBUtil dbUtil = new DBUtil();
    Connection con = null;
	public boolean addStudentToDB(String username,String password) throws SQLException, ClassNotFoundException
	{
		con = dbUtil.getDBConn();
        String query = "INSERT INTO studentusers(username, password) VALUES(?, ?);";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1,username);
        pstmt.setString(2,password);

        int rowsAffected = pstmt.executeUpdate();
        
        //System.out.println(rowsAffected);
        if(rowsAffected>0)
        {
        	return true;
        }
        return false;
	}
	public boolean checkUsernameExists(String username) throws SQLException,ClassNotFoundException {
		con = dbUtil.getDBConn();
		String query="SELECT COUNT(*) FROM studentusers WHERE username = ?;";
		PreparedStatement pstmt = con.prepareStatement(query);
		String usernametocheck= "SignupUsername";
		pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }
}

	


