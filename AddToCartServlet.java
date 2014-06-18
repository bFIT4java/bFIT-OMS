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
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here");
		String[] ids=request.getParameterValues("buyList");
		ProductList pl = new ProductList();
		//calls the product class to call the database and loads the product vectors
		pl.setVector();
		Vector<Integer> productId = pl.productId;
		PrintWriter pw = response.getWriter();
		
		//The below code will pull out the existing session, else null
		HttpSession ses=request.getSession();
		if(ses.getAttribute("username").equals(null)){
			
				response.sendRedirect("Login.html");
			
			
		}
		else{
			Vector vId=(Vector)ses.getAttribute("vecId");
			
			if(vId!=null){
				
				vId=(Vector)ses.getAttribute("vecId");
				
				for(String id:ids){
					vId.add((productId.elementAt(Integer.parseInt(id))));
				}
			}
			
			else{
			
				vId=new Vector();
				
				for(String id:ids){
					vId.add((productId.elementAt(Integer.parseInt(id))));
					
				}
			}
				ses.setAttribute("vecId",vId);
				pw.print("Item has been added<br>");
				pw.println("<a href=\"http://localhost:8082/OSM/LogoutServlet\"><b>Logout</b></a>");
				pw.println("<a href=\"http://localhost:8082/OSM/ProductServlet\"><b>Buy Items</b></a>");
			
		}
	}

	
}
