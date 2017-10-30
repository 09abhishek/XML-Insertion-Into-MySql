package com.abhi.XMLtomySQL;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertXML {
	
	private static final String INSERT_SQL =  "INSERT INTO XMLDUMP(FILENAME, MIMETYPE, CONTENT) values(?, ?, ?)";

    public void insert(File xmlFile) throws ClassNotFoundException {
    	try {
    	String myDriver = "org.gjt.mm.mysql.Driver";
         String myUrl = "jdbc:mysql://localhost/mydb";
         Class.forName(myDriver);
         Connection con = DriverManager.getConnection(myUrl, "root", "root");
    	
    	PreparedStatement ps = null;
        
            ps = con.prepareStatement(INSERT_SQL);
            ps.setString(1, xmlFile.getName());
            ps.setString(2, getMimeType(xmlFile));
            ps.setBinaryStream(3, new FileInputStream(xmlFile));
            ps.executeUpdate();
        } catch (SQLException e) {
            // CLOSE ps and con;
        } catch (FileNotFoundException e) {
           // CLOSE ps and con;
        } finally {
            // CLOSE ps and con;
        }
    }

     

     public String getMimeType(File xmlFile) {
         String mimeType = null;
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(xmlFile));
            mimeType = URLConnection.guessContentTypeFromStream(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mimeType;
     }

     public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
         InsertXML insertXML = new InsertXML();
         insertXML.insert(new File("D:\\ExternalFileLink\\product.xml"));
     }
}
