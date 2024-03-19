package com.abc.student.services;
import com.abc.student.dao.AuthAdmin;

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
 * Servlet implementation class authenticateStaff
 */
public class authenticateStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthAdmin auth=new AuthAdmin();
	boolean res;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticateStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String staffUsername=request.getParameter("staffUsername");
		String staffPassword=request.getParameter("staffPassword");
		try {
			res=auth.authenticateStaff(staffUsername, staffPassword);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		if (res) {
            request.setAttribute("loginStatus", "Success");
        } else {
            request.setAttribute("loginStatus", "Fail");
        }

		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
