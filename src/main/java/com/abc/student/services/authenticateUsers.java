package com.abc.student.services;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.abc.student.dao.AuthAdmin;


/**
 * Servlet implementation class authenticateUsers
 */
public class authenticateUsers extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AuthAdmin auth=new AuthAdmin();
	boolean res;
	public authenticateUsers() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String adminUsername=request.getParameter("adminUsername");
		String adminPassword=request.getParameter("adminPassword");
		try {
			 res= auth.authenticateAdmin(adminUsername,adminPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res)
		{
			out.println("Success");
		}
		else
		{
			out.println("fail");
		}
		out.println("Welcome to Admin Page");
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}