package entidades;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSql {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String host = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String pass = "root";
	private static final String dbname = "saladeensayo";
	
	public ConexionSql() {
		
	}
	
	public static Connection getOpenConnection() {
		
		Connection cn = null;
	
		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(host+dbname, user, pass);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return cn;
	}
	
	public static boolean closeConnection(Connection cn) {
		
		try {
			cn.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
