package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entidades.ConexionSql;
import entidades.Sala;
import idao.ISalaDao;

public class SalaDao implements ISalaDao{

	@Override
	public boolean Agregar(Sala sala) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO salas("
						+ "nombre,"
						+ "descripcion,"
						+ "precio) VALUES(?,?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, sala.getNombre());
			pst.setString(2, sala.getDescripcion());
			pst.setInt(3, sala.getPrecio());
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
	public boolean Modificar(Sala sala) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE salas SET "
						+ "nombre = ?,"
						+ "descripcion = ?,"
						+ "precio = ?,"
						+ "estado = ? WHERE idsala = " + sala.getId();
						
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, sala.getNombre());
			pst.setString(2, sala.getDescripcion());
			pst.setInt(3, sala.getPrecio());
			pst.setBoolean(4, sala.getEstado());
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
		String query = "UPDATE salas SET estado = 0 WHERE idsala = " + id;
						
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
		String query = "UPDATE salas SET estado = 1 WHERE idsala = " + id;
						
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
	public Sala Obtener(int id) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM salas WHERE idsala = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Sala sala = new Sala();
			sala.setId(rs.getInt(1));
			sala.setNombre(rs.getString(2));
			sala.setDescripcion(rs.getString(3));
			sala.setPrecio(rs.getInt(4));
			sala.setEstado(rs.getBoolean(5));
			
			ConexionSql.closeConnection(cn);
			return sala;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Sala> ObtenerTodas() {
		
		ArrayList<Sala> lista = new ArrayList<Sala>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM salas ORDER BY nombre ASC";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				Sala sala = new Sala();
				sala.setId(rs.getInt(1));
				sala.setNombre(rs.getString(2));
				sala.setDescripcion(rs.getString(3));
				sala.setPrecio(rs.getInt(4));
				sala.setEstado(rs.getBoolean(5));
				lista.add(sala);
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
