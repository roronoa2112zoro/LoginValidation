package org.home.projects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(userName.equalsIgnoreCase("munshi") && password.equalsIgnoreCase("password")) {
			out.println("you are successfully logged in !");
			out.println("<BR> Welcome , " + userName);
			
			Cookie cookie = new Cookie("cname", userName);
			response.addCookie(cookie);
		}else {
			out.println("Sorry , Username or Password error");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
	}

}