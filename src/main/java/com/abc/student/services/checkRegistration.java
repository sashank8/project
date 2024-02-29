package com.abc.student.services;

import com.abc.student.dao.AuthAdmin;
import com.abc.student.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DBUtil db = new DBUtil();
    AuthAdmin auth = new AuthAdmin();
    

    public checkRegistration() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String registrationNumber = request.getParameter("registrationNumber");
        
        boolean res = false;
		try {
			res = auth.checkStudentIfExist(registrationNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
        if(res) {
        	try {
        		String regisQuery = "SELECT registration_number, name, email, attendance, percentage, branch FROM studentdetails WHERE registration_number = ?";
        		Connection con = db.getDBConn();
        		PreparedStatement statement = con.prepareStatement(regisQuery);
        		statement.setString(1, registrationNumber);
        		ResultSet result = statement.executeQuery();

        		if (result.next()) {
        			request.setAttribute("name", result.getString("name"));
        			request.setAttribute("email", result.getString("email"));
        			request.setAttribute("attendance", result.getInt("attendance"));
        			double percentage;
        			int percentageAsInt = result.getInt("percentage");
        			if (percentageAsInt != 0) {
        				percentage = percentageAsInt;
        			} else {
        				percentage = result.getDouble("percentage");
        			}
        			request.setAttribute("percentage", percentage);
        			request.setAttribute("branch", result.getString("branch"));
        		}

        		request.getRequestDispatcher("checkRegistration.jsp").forward(request, response);
        	} catch (SQLException | ClassNotFoundException e) {
        		e.printStackTrace();
        	}
        }
        else
        {
        	out.print("<html>"
                    + "<head>"
                    + "<title>Error</title>"
                    + "</head>"
                    + "<body>"
                    + "<center>"
                    + "<h1>Enter a Valid Registration Number</h1>"
                    + "</center>"
                    + "</body>"
                    + "</html>");
        	
        }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
