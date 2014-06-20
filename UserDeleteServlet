package com.ust;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDeleteServlet
 */
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids=request.getParameterValues("buyList");
		ProductList pl = new ProductList();
		//calls the product class to call the database and loads the product vectors
		pl.setVector();
		Vector<Integer> productId = pl.productId;
		PrintWriter pw = response.getWriter();
		Vector vId=new Vector();
		//The below code will pull out the existing session, else null
		HttpSession ses=request.getSession();
		Vector num = new Vector();
		if(ses.getAttribute("username").equals(null)){
			
				response.sendRedirect("Login.html");
			
			
		}
		else{	
				
				for(String id:ids){
					vId.add(id);	
				}
				AddCartClass acc = new AddCartClass();
				acc.deleteId(vId,ses.getAttribute("vecId"));
				vId=acc.productId;
			}
				
				ses.setAttribute("vecId",vId);
				pw.print("Item(s) has been deleted<br>");
				pw.println("<a href=\"http://localhost:8082/OSM/LogoutServlet\"><b>Logout</b></a>");
				pw.println("<a href=\"http://localhost:8082/OSM/ProductServlet\"><b>Buy Items</b></a>");
				pw.println("<a href=\"http://localhost:8082/OSM/displayCartServlet\"><b>View Cart</b></a>");
				
			
		
	}

}
