package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.ConexionSql;
import entidades.Servicio;
import idao.IServicioDao;

public class ServicioDao implements IServicioDao{

	@Override
	public boolean Agregar(Servicio servicio) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO servicios("
						+ "descripcion,"
						+ "precio) VALUES(?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, servicio.getDescripcion());
			pst.setInt(2, servicio.getPrecio());
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
	public boolean Modificar(Servicio servicio) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE servicios SET "
						+ "descripcion = ?,"
						+ "precio = ?,"
						+ "estado = ? WHERE idservicio = " + servicio.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, servicio.getDescripcion());
			pst.setInt(2, servicio.getPrecio());
			pst.setBoolean(3, servicio.getEstado());
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
		String query = "UPDATE servicios SET estado = 0 WHERE idservicio = " + id;
		
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
		String query = "UPDATE servicios SET estado = 1 WHERE idservicio = " + id;
		
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
	public Servicio Obtener(int id) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM servicios WHERE idservicio = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Servicio servicio = new Servicio();
			servicio.setId(rs.getInt(1));
			servicio.setDescripcion(rs.getString(2));
			servicio.setPrecio(rs.getInt(3));
			servicio.setEstado(rs.getBoolean(4));
			
			ConexionSql.closeConnection(cn);
			return servicio;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Servicio> ObtenerTodos() {
		
		ArrayList<Servicio> lista = new ArrayList<Servicio>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM servicios ORDER BY descripcion ASC";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				Servicio servicio = new Servicio();
				servicio.setId(rs.getInt(1));
				servicio.setDescripcion(rs.getString(2));
				servicio.setPrecio(rs.getInt(3));
				servicio.setEstado(rs.getBoolean(4));
				lista.add(servicio);
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
