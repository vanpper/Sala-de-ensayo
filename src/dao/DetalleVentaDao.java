package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.ConexionSql;
import entidades.DetalleVenta;
import idao.IDetalleVentaDao;

public class DetalleVentaDao implements IDetalleVentaDao {

	@Override
	public boolean Agregar(int idventa, DetalleVenta detalle) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO detalleventas VALUES(?,?,?,?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, idventa);
			pst.setInt(2, detalle.getAlimento().getId());
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
	public boolean Modificar(int idventa, DetalleVenta detalle) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE detalleventas SET "
						+ "cantidad = ?,"
						+ "precio = ?,"
						+ "subtotal = ? WHERE idventa = " + idventa + " AND "
						+ "idalimento = " + detalle.getAlimento().getId();
		
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
	public boolean Eliminar(int idventa, int idalimento) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "DELETE FROM detalleventas WHERE idventa = " + idventa + " AND "
						+ "idalimento = " + idalimento;
		
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
	public DetalleVenta Obtener(int idventa, int idalimento) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM detalleventas WHERE idventa = " + idventa + " AND idalimento = " + idalimento;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();

			DetalleVenta detalle = new DetalleVenta();
			detalle.setAlimento(new AlimentoDao().Obtener(rs.getInt(2)));
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
	public ArrayList<DetalleVenta> ObtenerTodos(int idventa) {
		
		ArrayList<DetalleVenta> lista = new ArrayList<DetalleVenta>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM detalleventas WHERE idventa = " + idventa;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				DetalleVenta detalle = new DetalleVenta();
				detalle.setAlimento(new AlimentoDao().Obtener(rs.getInt(2)));
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
