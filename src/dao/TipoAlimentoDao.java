package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entidades.ConexionSQL;
import entidades.TipoAlimento;
import idao.ITipoAlimentoDao;

public class TipoAlimentoDao implements ITipoAlimentoDao {

	@Override
	public TipoAlimento Obtener(int id) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM tiposalimento WHERE idtipoalimento = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			TipoAlimento tipo = new TipoAlimento();
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
	public ArrayList<TipoAlimento> ObtenerTodos() {
		
		ArrayList<TipoAlimento> lista = new ArrayList<TipoAlimento>();
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM tiposalimento";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				TipoAlimento tipo = new TipoAlimento();
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
