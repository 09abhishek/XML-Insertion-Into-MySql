package com.abhi.BLOBandCLOB;

import java.io.*;
import java.sql.*;

public class GettingDataFromDb {
	public static void main(String args[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");

			File file=new File("D:\\ExternalFileLink\\RetriveImages\\file.xml");
			FileOutputStream fos=new FileOutputStream(file);
			byte b[];
			Blob blob;

			PreparedStatement ps=con.prepareStatement("select * from data_table"); 
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				blob=rs.getBlob("file");
				b=blob.getBytes(1,(int)blob.length());
				fos.write(b);
			}

			ps.close();
			fos.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}