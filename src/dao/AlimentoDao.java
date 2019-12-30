package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Alimento;
import entidades.ConexionSql;
import idao.IAlimentoDao;

public class AlimentoDao implements IAlimentoDao{

	@Override
	public boolean Agregar(Alimento alimento) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO alimentos("
						+ "nombre,"
						+ "descripcion,"
						+ "idtipoalimento,"
						+ "precio) VALUES(?,?,?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, alimento.getNombre());
			pst.setString(2, alimento.getDescripcion());
			pst.setInt(3, alimento.getTipo().getId());
			pst.setInt(4, alimento.getPrecio());
			pst.executeUpdate();
			
			ConexionSql.closeConnection(cn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return false;
		}
	}

	@Override
	public boolean Modificar(Alimento alimento) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE alimentos SET "
						+ "nombre = ?,"
						+ "descripcion = ?,"
						+ "idtipoalimento = ?,"
						+ "precio = ?,"
						+ "estado = ? WHERE idalimento = " + alimento.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, alimento.getNombre());
			pst.setString(2, alimento.getDescripcion());
			pst.setInt(3, alimento.getTipo().getId());
			pst.setInt(4, alimento.getPrecio());
			pst.setBoolean(5, alimento.getEstado());
			pst.executeUpdate();
			
			ConexionSql.closeConnection(cn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return false;
		}
	}

	@Override
	public boolean Eliminar(int id) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE alimentos SET estado = 0 WHERE idalimento = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.executeUpdate();
			
			ConexionSql.closeConnection(cn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return false;
		}
	}

	@Override
	public boolean Restaurar(int id) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE alimentos SET estado = 1 WHERE idalimento = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.executeUpdate();
			
			ConexionSql.closeConnection(cn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return false;
		}
	}

	@Override
	public Alimento Obtener(int id) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM alimentos WHERE idalimento = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Alimento alimento = new Alimento();
			alimento.setId(rs.getInt(1));
			alimento.setNombre(rs.getString(2));
			alimento.setDescripcion(rs.getString(3));
			alimento.setTipo(new TipoAlimentoDao().Obtener(rs.getInt(4)));
			alimento.setPrecio(rs.getInt(5));
			alimento.setEstado(rs.getBoolean(6));
			
			ConexionSql.closeConnection(cn);
			return alimento;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Alimento> ObtenerTodos() {
		
		ArrayList<Alimento> lista = new ArrayList<Alimento>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM alimentos ORDER BY nombre ASC";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				Alimento alimento = new Alimento();
				alimento.setId(rs.getInt(1));
				alimento.setNombre(rs.getString(2));
				alimento.setDescripcion(rs.getString(3));
				alimento.setTipo(new TipoAlimentoDao().Obtener(rs.getInt(4)));
				alimento.setPrecio(rs.getInt(5));
				alimento.setEstado(rs.getBoolean(6));
				lista.add(alimento);
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
