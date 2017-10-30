package com.abhi.XMLtomySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class push {
	public static void main()throws SQLException, ClassNotFoundException
	{

		
		Class.forName("com.mysql.jdbc.Driver"); 
		String dbUrl="jdbc:mysql://localhost/mydb?user=root&password=root";
		Connection conn = DriverManager.getConnection(dbUrl);
		
		conn.createStatement().execute("CREATE TABLE books(\n" +
	         " id integer primary key auto_increment,\n" +
	         " book_id varchar(25) not null unique,\n" +
	         " author varchar(50) not null,\n" +
	         " title varchar(250) not null,\n" +
	         " genre varchar(25) not null,\n" +
	         " price float not null,\n" +
	         " publish_date date not null,\n" +
	         " description text not null\n" +
	         ")");
		conn.close();
	}
}
