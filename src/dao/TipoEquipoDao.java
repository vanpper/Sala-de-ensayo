package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entidades.ConexionSql;
import entidades.TipoEquipo;
import idao.ITipoEquipoDao;

public class TipoEquipoDao implements ITipoEquipoDao{

	@Override
	public TipoEquipo Obtener(int id) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM tiposequipo WHERE idtipoequipo = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			TipoEquipo tipo = new TipoEquipo();
			tipo.setId(rs.getInt(1));
			tipo.setDescripcion(rs.getString(2));
			
			ConexionSql.closeConnection(cn);
			return tipo;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<TipoEquipo> ObtenerTodos() {
		
		ArrayList<TipoEquipo> lista = new ArrayList<TipoEquipo>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM tiposequipo";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				TipoEquipo tipo = new TipoEquipo();
				tipo.setId(rs.getInt(1));
				tipo.setDescripcion(rs.getString(2));
				lista.add(tipo);
			}
			
			ConexionSql.closeConnection(cn);
			return lista;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

}
