package com.abc.student.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import com.abc.student.dao.addStudent;
import com.abc.student.util.DBUtil;

/**
 * Servlet implementation class registerStudent
 */
public class registerStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		boolean res=false;
        PrintWriter out = response.getWriter();
        String signupUsername = request.getParameter("signupUsername");
        String signupPassword = request.getParameter("signupPassword");
        //out.println(signupUsername);
        //out.println(signupPassword);
        
        addStudent addstd = new addStudent();
        try {
        	if (addstd.checkUsernameExists(signupUsername)) {
                out.print("<html>"
                        + "<head>"
                        + "<title>Error</title>"
                        + "</head>"
                        + "<body>"
                        + "<center>"
                        + "<h1>Username already exists! Please choose a different username.</h1>"
                        + "</center>"
                        + "</body>"
                        + "</html>"
                );
                return;
            }
        	res=addstd.addStudentToDB(signupUsername, signupPassword);
		}
        
        catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(res)
        {
        	out.print("<html>"
        			+ "<head>"
        			+ "<title>Success</title>"
        			+ "</head>"
        			+ "<body>"
        			+ "<center>"
        			+ "<h1>Registered Successfully ! ! !</h1>"
        			+ "</center>"
        			+ "</body>"
        			+ "</html>"
        			);
        }
        else
        {
        	out.print("fail");
        }
	}

}
