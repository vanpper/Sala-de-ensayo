package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entidades.ConexionSQL;
import entidades.TipoEquipo;
import idao.ITipoEquipoDao;

public class TipoEquipoDao implements ITipoEquipoDao{

	@Override
	public TipoEquipo Obtener(int id) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM tiposequipo WHERE idtipoequipo = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			TipoEquipo tipo = new TipoEquipo();
			tipo.setId(rs.getInt(1));
			tipo.setDescripcion(rs.getString(2));
			
			ConexionSQL.closeConnection(cn);
			return tipo;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<TipoEquipo> ObtenerTodos() {
		
		ArrayList<TipoEquipo> lista = new ArrayList<TipoEquipo>();
		Connection cn = ConexionSQL.getOpenConnection();
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
			
			ConexionSQL.closeConnection(cn);
			return lista;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(cn);
			return null;
		}
	}

}
