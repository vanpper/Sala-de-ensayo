package principal;

import java.sql.Connection;

import entidades.ConexionSQL;

public class Main {

	public static void main(String[] args) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		
		try {
			System.out.println(cn.isClosed());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
