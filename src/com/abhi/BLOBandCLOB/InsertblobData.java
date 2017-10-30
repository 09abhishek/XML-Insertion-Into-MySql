package com.abhi.BLOBandCLOB;

	import java.io.File;
	import java.io.FileInputStream;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class InsertblobData {
	  public static void main(String[] args) throws Exception, SQLException 
	  {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
	    //String INSERT_PICTURE = "insert into MyPictures(id, name, photo) values (?, ?, ?)";
	    String query = "insert into mypic2(id, name, photo) values (?, ?, ?)";
	    FileInputStream fis = null;
	    PreparedStatement ps = null;
	    try {
	      conn.setAutoCommit(false);
	      File file = new File("D:\\ExternalFileLink\\java.png");
	      fis = new FileInputStream(file);
	      ps = conn.prepareStatement(query);
	      ps.setString(1, "003");
	      ps.setString(2, "java pic");
	      ps.setBinaryStream(3, fis, (int) file.length());
	      ps.executeUpdate();
	      conn.commit();
	    } finally {
	      ps.close();
	      fis.close();
	    }
	  }
	}

