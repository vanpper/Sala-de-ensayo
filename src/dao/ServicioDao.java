package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.ConexionSQL;
import entidades.Servicio;
import idao.IServicioDao;

public class ServicioDao implements IServicioDao{

	@Override
	public boolean Agregar(Servicio servicio) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "INSERT INTO serviciosespeciales("
						+ "descripcion,"
						+ "precio) VALUES(?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, servicio.getDescripcion());
			pst.setInt(2, servicio.getPrecio());
			pst.executeUpdate();
			
			ConexionSQL.closeConnection(cn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(cn);
			return false;
		}
	}

	@Override
	public boolean Modificar(Servicio servicio) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "UPDATE serviciosespeciales SET "
						+ "descripcion = ?,"
						+ "precio = ?,"
						+ "estado = ? WHERE idservicio = " + servicio.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, servicio.getDescripcion());
			pst.setInt(2, servicio.getPrecio());
			pst.setBoolean(3, servicio.getEstado());
			pst.executeUpdate();
			
			ConexionSQL.closeConnection(cn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(cn);
			return false;
		}
	}

	@Override
	public boolean Eliminar(int id) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "UPDATE serviciosespeciales SET estado = 0 WHERE idservicio = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.executeUpdate();
			
			ConexionSQL.closeConnection(cn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(cn);
			return false;
		}
	}

	@Override
	public boolean Restaurar(int id) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "UPDATE serviciosespeciales SET estado = 1 WHERE idservicio = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.executeUpdate();
			
			ConexionSQL.closeConnection(cn);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(cn);
			return false;
		}
	}

	@Override
	public Servicio Obtener(int id) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM serviciosespeciales WHERE idservicio = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Servicio servicio = new Servicio();
			servicio.setId(rs.getInt(1));
			servicio.setDescripcion(rs.getString(2));
			servicio.setPrecio(rs.getInt(3));
			servicio.setEstado(rs.getBoolean(4));
			
			ConexionSQL.closeConnection(cn);
			return servicio;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Servicio> ObtenerTodos() {
		
		ArrayList<Servicio> lista = new ArrayList<Servicio>();
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM serviciosespeciales ORDER BY descripcion ASC";
		
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
