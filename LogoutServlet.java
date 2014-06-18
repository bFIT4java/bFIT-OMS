package com.ust;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		PrintWriter pw = response.getWriter();
		System.out.println((String)session.getAttribute("username"));
		AddCartClass pl = new AddCartClass();
		
		if(session.getAttribute("username").equals(null)){
			
			response.sendRedirect("Login.html");
		
		
		}
		else{
			System.out.println("in servlet"+session.getAttribute("vecId"));
			System.out.println("in servlet"+session.getAttribute("username"));
			pl.addToShoppingCart(session.getAttribute("vecId"),session.getAttribute("username") );
			if(!session.getAttribute("username").equals(null)||!session.getAttribute("username").equals("")){
				session.invalidate();
				pw.println("You have successfully logged out");
				pw.println("<a href=\"Login.html\">log in</a>");

			
			}
		}
	}


}
