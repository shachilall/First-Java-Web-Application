package com.firstwebapp.servlets;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstwebapp.beans.UserAccount;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        RequestDispatcher dispatcher 
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(request, response);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get request parameter values
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //create bean object
        UserAccount  user = new UserAccount();
        user.setUserName(userName);
        user.setPassword(password);
        // if error exists in validating the user, send request back to login page with error message
        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", "Required username and password!");
            request.setAttribute("user", user);
            RequestDispatcher dispatcher 
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
        } 
        // if user is valid , redirect to UserInfo Servlet
        else {
        	// Store information in session attribute, before forward.
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }
	}
}
