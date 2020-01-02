package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidades.ConexionSql;
import java.util.ArrayList;

import entidades.DetalleAlquiler;
import idao.IDetalleAlquilerDao;

public class DetalleAlquilerDao implements IDetalleAlquilerDao{

	@Override
	public boolean Agregar(int idalquiler, DetalleAlquiler detalle) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO detallealquileres VALUES(?,?,?,?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, idalquiler);
			pst.setInt(2, detalle.getEquipo().getId());
			pst.setInt(3, detalle.getCantidad());
			pst.setInt(4, detalle.getPrecio());
			pst.setInt(5, detalle.getSubtotal());
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
	public boolean Modificar(int idalquiler, DetalleAlquiler detalle) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE detallealquileres SET "
						+ "cantidad = ?,"
						+ "precio = ?,"
						+ "subtotal = ? WHERE idalquiler = " + idalquiler + " AND "
						+ "idequipo = " + detalle.getEquipo().getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, detalle.getCantidad());
			pst.setInt(2, detalle.getPrecio());
			pst.setInt(3, detalle.getSubtotal());
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
	public boolean Eliminar(int idalquiler, int idequipo) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "DELETE FROM detallealquileres WHERE idalquiler = " + idalquiler + " AND idequipo = " + idequipo;
		
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
	public DetalleAlquiler Obtener(int idalquiler, int idequipo) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM detallealquileres WHERE idalquiler = " + idalquiler + " AND "
						+ "idequipo = " + idequipo;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			DetalleAlquiler detalle = new DetalleAlquiler();
			detalle.setEquipo(new EquipoDao().Obtener(rs.getInt(2)));
			detalle.setCantidad(rs.getInt(3));
			detalle.setPrecio(rs.getInt(4));
			detalle.setSubtotal(rs.getInt(5));
			
			ConexionSql.closeConnection(cn);
			return detalle;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<DetalleAlquiler> ObtenerTodos(int idalquiler) {
		
		ArrayList<DetalleAlquiler> lista = new ArrayList<DetalleAlquiler>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM detallealquileres WHERE idalquiler = " + idalquiler;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {

				DetalleAlquiler detalle = new DetalleAlquiler();
				detalle.setEquipo(new EquipoDao().Obtener(rs.getInt(2)));
				detalle.setCantidad(rs.getInt(3));
				detalle.setPrecio(rs.getInt(4));
				detalle.setSubtotal(rs.getInt(5));
				lista.add(detalle);
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
