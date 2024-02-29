package com.abc.student.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.abc.student.dao.AuthAdmin;

/**
 * Servlet implementation class authenticateStudent
 */
public class authenticateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthAdmin auth=new AuthAdmin();
	boolean res;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String studentUsername=request.getParameter("studentUsername");
		String studentPassword=request.getParameter("studentPassword");
		try {
			res=auth.authenticateStudent(studentUsername, studentPassword);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res)
		{
			response.sendRedirect("registration.html");
		}
		else
		{
			out.println("fail");
		}
		out.println("Welcome to student Page");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
