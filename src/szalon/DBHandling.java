package szalon;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class DBHandling {
	private static String dbName = "felhasznalo_db";
	private static String dbUser = "root";
	private static String dbPassword = "";
	private static String dbPort = "3306";
	private static String dbUrl = "localhost";
	
	public static void connect() {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + dbName + "",
				dbUser, dbPassword)) {
			Class.forName("com.mysql.jdbc.Driver");
			;

			//System.out.println(lista.size());
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "nem sikerült kapcsolódni");
		}
	}
}
