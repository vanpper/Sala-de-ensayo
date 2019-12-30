package entidades;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQL {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String host = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String pass = "root";
	private static final String dbname = "saladeensayo";
	
	public ConexionSQL() {
		
	}
	
	public static Connection getOpenConnection() {
		
		Connection cn = null;
	
		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(host+dbname, user, pass);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return cn;
	}
}
