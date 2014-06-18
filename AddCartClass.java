package com.ust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class AddCartClass {
	public Vector<Integer> productId=new Vector<Integer>();
	public Vector<String> productName=new Vector<String>();
	public Vector<Double> productPrice=new Vector<Double>();
	public Vector<Integer> productQty=new Vector<Integer>();
	public double total;
	
	public void addToShoppingCart(Object id, Object username){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","jades123");
			
			if(con!=null){
				System.out.println("has connected to db not null");
				//You are successfully connected to DATABASE	
		
				PreparedStatement psmt = con.prepareStatement("UPDATE SHOPPING_CART SET PRODUCTID = ? WHERE USERNAME = ? ");
				
				
				//adds session shopping cart to the table to save it for next login
				Object tempId =id;
				System.out.println(id);
				Vector productId = (Vector)tempId;
			
				String addId="";
				for(int i =0; i<productId.size();i++){
					
					addId+=(String.valueOf(productId.elementAt(i))+",");
				}

				
				System.out.println(addId);
				String un=(String)username;
			     psmt.setString(1, addId);
			     psmt.setString(2, un);
			    int rows= psmt.executeUpdate();
			    System.out.println("number of updates"+rows);
			     psmt.close();
			    
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
	
	public boolean checkShoppingCart(String username){
		boolean found=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","jades123");
			
			if(con!=null){
				Statement stmt=con.createStatement();
				
				// execute select SQL stetement
				ResultSet rs=stmt.executeQuery("select * from SHOPPING_CART");

				while (rs.next()) {
					String un=rs.getString(1);
					if(un.equals(username)){
						String tempId=rs.getString(2);
						System.out.println(tempId);
						if(!tempId.equals(null)){
							found=true;
							String[] tempIds=tempId.split(",");
							for(int i=0;i<tempIds.length;i++){
								productId.add(Integer.parseInt(tempIds[i]));
							}
							System.out.println(productId);
						}							
					}
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
			return found;
	}
	
	@SuppressWarnings("unchecked")
	public void setCart(Object id){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","jades123");
			
			if(con!=null){
				productId=(Vector<Integer>) id;
				for(int i =0;i<productId.size();i++){
					int tempId=productId.elementAt(i);
					if(productQty.size()!=0){
						
					}
					else{
						//start adding first element
					}
				}
			}
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
