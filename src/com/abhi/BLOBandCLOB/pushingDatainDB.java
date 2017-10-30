package com.abhi.BLOBandCLOB;

import java.sql.*;
import java.io.*;

public class pushingDatainDB {
	public static void main(String args[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");

			File file=new File("D:\\ExternalFileLink\\MN_0023.xml");
			FileInputStream fis=new FileInputStream(file);

			PreparedStatement ps=con.prepareStatement("insert into data_table (name,file) values(?,?)"); 
			ps.setString(1,"menu");
			ps.setBinaryStream(2,fis,(int)file.length());
			ps.executeUpdate();

			ps.close();
			fis.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}