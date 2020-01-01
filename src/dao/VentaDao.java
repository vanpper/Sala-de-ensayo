package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.ConexionSql;
import entidades.Venta;
import idao.IVentaDao;

public class VentaDao implements IVentaDao{

	@Override
	public boolean Agregar(Venta venta) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO ventas(idreserva, total) VALUES(?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, venta.getReserva().getId());
			pst.setInt(2, venta.getTotal());
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
	public boolean Modificar(Venta venta) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE ventas SET total = ? WHERE idventa = " + venta.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, venta.getTotal());
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
	public Venta Obtener(int idventa) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM ventas WHERE idventa = " + idventa;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Venta venta = new Venta();
			venta.setId(rs.getInt(1));
			venta.setReserva(new ReservaDao().Obtener(rs.getInt(2)));
			venta.setTotal(rs.getInt(3));
			
			ConexionSql.closeConnection(cn);
			return venta;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Venta> ObtenerTodas(int idreserva) {
		
		ArrayList<Venta> lista = new ArrayList<Venta>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM ventas WHERE idreserva = " + idreserva;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				Venta venta = new Venta();
				venta.setId(rs.getInt(1));
				venta.setReserva(new ReservaDao().Obtener(rs.getInt(2)));
				venta.setTotal(rs.getInt(3));
				lista.add(venta);
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
