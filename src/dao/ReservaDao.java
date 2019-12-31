package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.ConexionSql;
import entidades.Fecha;
import entidades.Reserva;
import idao.IReservaDao;

public class ReservaDao implements IReservaDao{

	@Override
	public boolean Agregar(Reserva reserva) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO reservas("
						+ "idbanda,"
						+ "idsala,"
						+ "fecha,"
						+ "hora_desde,"
						+ "hora_hasta,"
						+ "precio) VALUES(?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, reserva.getBanda().getId());
			pst.setInt(2, reserva.getSala().getId());
			pst.setString(3, reserva.getFecha().toDate());
			pst.setInt(4, reserva.getHoraDesde());
			pst.setInt(5, reserva.getHoraHasta());
			pst.setInt(6, reserva.getPrecio());
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
	public boolean Modificar(Reserva reserva) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE reservas SET "
						+ "idbanda = ?,"
						+ "idsala = ?,"
						+ "fecha = ?,"
						+ "hora_desde = ?,"
						+ "hora_hasta = ?,"
						+ "precio = ?,"
						+ "estado = ? WHERE idreserva = " + reserva.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, reserva.getBanda().getId());
			pst.setInt(2, reserva.getSala().getId());
			pst.setString(3, reserva.getFecha().toDate());
			pst.setInt(4, reserva.getHoraDesde());
			pst.setInt(5, reserva.getHoraHasta());
			pst.setInt(6, reserva.getPrecio());
			pst.setBoolean(7, reserva.getEstado());
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
		String query = "UPDATE reservas SET estado = 0 WHERE idreserva = " + id;
		
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
		String query = "UPDATE reservas SET estado = 1 WHERE idreserva = " + id;
		
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
	public Reserva Obtener(int id) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM reservas WHERE idreserva = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Reserva reserva = new Reserva();
			reserva.setId(rs.getInt(1));
			reserva.setBanda(new BandaDao().Obtener(rs.getInt(2)));
			reserva.setSala(new SalaDao().Obtener(rs.getInt(3)));
			reserva.setFecha(new Fecha(rs.getDate(4)));
			reserva.setHoraDesde(rs.getInt(5));
			reserva.setHoraHasta(rs.getInt(6));
			reserva.setPrecio(rs.getInt(7));
			reserva.setEstado(rs.getBoolean(8));
			
			ConexionSql.closeConnection(cn);
			return reserva;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Reserva> ObtenerTodas() {
		
		ArrayList<Reserva> lista = new ArrayList<Reserva>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM reservas";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				Reserva reserva = new Reserva();
				reserva.setId(rs.getInt(1));
				reserva.setBanda(new BandaDao().Obtener(rs.getInt(2)));
				reserva.setSala(new SalaDao().Obtener(rs.getInt(3)));
				reserva.setFecha(new Fecha(rs.getDate(4)));
				reserva.setHoraDesde(rs.getInt(5));
				reserva.setHoraHasta(rs.getInt(6));
				reserva.setPrecio(rs.getInt(7));
				reserva.setEstado(rs.getBoolean(8));
				lista.add(reserva);			
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
