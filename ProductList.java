package com.ust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class ProductList {
	public Vector<String> productName=new Vector<String>();
	public Vector<Integer> productId=new Vector<Integer>();
	public Vector<Double> productPrice=new Vector<Double>();
public void setVector(){
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","jades123");
		
		if(con!=null){
			//You are successfully connected to DATABASE	
			//pULL OUT ALL USERNAMES &PASSWORDS FROM USERS TABLE
			//compare them with the one that is entered in html page
			//if anyone of them is matching, that means, you are a Valid USER
			//else, you are a fraud
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from product");
			
			//adds the data from the data table to the vectors
			while (rs.next())
			{
				String name= rs.getString(2);
				int id=Integer.parseInt(rs.getString(1));
				Double price=Double.parseDouble(rs.getString(3));
				
						productName.add(name);
						productId.add(id);
						productPrice.add(price);
			}
	
		}
		con.close();
		}
		catch(Exception e){
			System.out.println("Database connection not successful...");
			System.out.println("This might be due to various reasons..");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		
}





}
