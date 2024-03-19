package com.abc.student.services;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.abc.student.dao.AuthAdmin;
import com.abc.student.dao.Student;


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
			if(auth.authenticateAdmin(adminUsername,adminPassword)) {
					List<Student> students = auth.getAllStudents();
					 for (Student student : students) {
			                System.out.println("Received Student: " + student.getRegistrationNumber() + ", " + student.getName() + ", " + student.getEmail() + ", " + student.getAttendance() + ", " + student.getPercentage() + ", " + student.getBranch());
			            }
					request.setAttribute("students", students);
					System.out.println("Students attribute set in request: " + students);
					request.getRequestDispatcher("studentDetails.jsp").forward(request, response);
				}
			else {
				response.sendRedirect("index.html");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Reached the doGet() method of authenticateUsers servlet.");
		 
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
