package szalon;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DBHandling  {
	private static String dbUser = "root";
	private static String dbPassword = "";
	
	public static Connection connect() {
		Connection con=null;
		try {
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oraszalon",dbUser, dbPassword);
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "nem sikerült kapcsolódni a db-hez: "+e.getMessage());
			System.exit(0);
		}
		return con;
	}
	
	public static void insertData(String nev,int ar, boolean vizallo, String tipus) {
		Connection con= connect();
		try {
			PreparedStatement sql=con.prepareStatement("insert into orak VALUES (null,?,?,?,?)");
			sql.setString(1, nev);
			sql.setString(2, tipus);
			sql.setInt(3, ar);
			sql.setBoolean(4, vizallo);
			sql.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "nem sikerült menteni: "+e.getMessage());
		}  
		
		
	}

	
}
