package com.abc.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.abc.student.util.DBUtil;

public class AuthAdmin {
	//public String Auth_Admin="select 1 from adminusers where username=? and password=?;";
	DBUtil db = new DBUtil();
	public boolean authenticateAdmin(String username,String password)throws SQLException
	{
		String Auth_Query="select 1 from adminusers where username='"+username+"' and password='"+password+"';";
		ResultSet res;
		int value=0;
		try {
			Connection con = db.getDBConn();
			//PreparedStatement p = con.prepareStatement(Auth_Admin);
			//p.setString(1,username);
			//p.setString(2, password);
			//res=p.executeQuery();
			
			Statement smt =con.createStatement();
			
			res = smt.executeQuery(Auth_Query);
			
			//System.out.println(res.getInt("1"));
			while(res.next())
			{
				value=res.getInt("1");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		if(value==1)
		{
			return true;
		}
		return false;
	}
	public boolean authenticateStudent(String username,String password)throws SQLException{
		String Stud_Query="select 1 from studentusers where username='"+username+"' and password='"+password+"';";
		ResultSet res;
		int value=0;
		try {
			Connection con=db.getDBConn();
			Statement smt=con.createStatement();
			res=smt.executeQuery(Stud_Query);
			while(res.next()) {
				value=res.getInt("1");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		if(value==1)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean checkStudentIfExist(String regNo)throws SQLException
	{
		String Check_Query="Select 1 from studentdetails where registration_number = ? ";
		int value=0;
		try {
    		Connection con = db.getDBConn();
    		PreparedStatement statement = con.prepareStatement(Check_Query);
    		statement.setString(1, regNo);
    		ResultSet result = statement.executeQuery();
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
	
}
