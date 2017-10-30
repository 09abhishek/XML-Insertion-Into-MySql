package com.abhi.XMLtomySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SimplejdbcProgramtoReadDBdata
{
	
public static void main(String[] args) throws Exception
{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from users");
			
			while(rs.next())
			{
		    System.out.print(rs.getInt("uid")+ "\t");
	    	System.out.print(rs.getString("uname")+ "\t");
	    	System.out.print(rs.getString("upassword")+ "\t");
		    System.out.print(rs.getInt("status")+ "\t\n");
          }
          rs.close();st.close();
          con.close();
}
}