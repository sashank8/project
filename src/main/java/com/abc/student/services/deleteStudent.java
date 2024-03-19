package com.abc.student.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.abc.student.dao.AuthAdmin;
import com.abc.student.dao.Student;
import com.abc.student.util.DBUtil;

/**
 * Servlet implementation class deleteStudent
 */
public class deleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DBUtil db = new DBUtil();
	AuthAdmin auth = new AuthAdmin();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteStudent() {
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
		doGet(request, response);
		String registrationNumber = request.getParameter("registrationNumber");
		 if (registrationNumber != null && !registrationNumber.isEmpty()) {
	            try {
	                // Call method to delete student
	                if (auth.deleteStudent(registrationNumber)) {
	                    // Refresh student details after deletion
	                    List<Student> students = auth.getAllStudents();
	                    request.setAttribute("students", students);
	                    request.getRequestDispatcher("studentDetails.jsp").forward(request, response);
	                } else {
	                    // Handle failure to delete
	                    response.getWriter().println("Failed to delete student.");
	                }
	            } catch (SQLException e) {
	                // Handle database exception
	                e.printStackTrace();
	                response.getWriter().println("Database error: " + e.getMessage());
	            }
	        } else {
	            // Invalid request
	            response.getWriter().println("Invalid request.");
	        }
	    }
	}
