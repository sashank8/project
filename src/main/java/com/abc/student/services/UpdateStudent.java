package com.abc.student.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.abc.student.dao.AuthAdmin;

/**
 * Servlet implementation class UpdateStudent
 */
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  AuthAdmin auth = new AuthAdmin();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
		
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int attendance = Integer.parseInt(request.getParameter("attendance"));
        int percentage = Integer.parseInt(request.getParameter("percentage"));
        String branch = request.getParameter("branch");
        String registrationNumber = request.getParameter("registrationNumber");

        try {
            boolean success = auth.updateStudent(registrationNumber, name, email, attendance, percentage, branch);
            if (success) {
                response.sendRedirect("studentDetails.jsp");
            } else {
                // Handle update failure
                response.getWriter().println("Failed to update student.");
            }
        } catch (SQLException e) {
            // Handle database exception
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }
}

