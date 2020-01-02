package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Alquiler;
import entidades.ConexionSql;
import idao.IAlquilerDao;

public class AlquilerDao implements IAlquilerDao{

	@Override
	public boolean Agregar(Alquiler alquiler) {

		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO alquileres(idreserva, total) VALUES(?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, alquiler.getReserva().getId());
			pst.setInt(2, alquiler.getTotal());
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
	public boolean Modificar(Alquiler alquiler) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE alquileres SET idreserva = ?, total = ?, estado = ? WHERE idalquiler = " + alquiler.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, alquiler.getReserva().getId());
			pst.setInt(2, alquiler.getTotal());
			pst.setBoolean(3, alquiler.getEstado());
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
	public boolean Eliminar(int idalquiler) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE alquileres SET estado = 0 WHERE idalquiler = " + idalquiler;
		
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
	public boolean Restaurar(int idalquiler) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE alquileres SET estado = 1 WHERE idalquiler = " + idalquiler;
		
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
	public Alquiler Obtener(int idalquiler) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM alquileres WHERE idalquiler = " + idalquiler;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Alquiler alquiler = new Alquiler();
			alquiler.setId(rs.getInt(1));
			alquiler.setReserva(new ReservaDao().Obtener(rs.getInt(2)));
			alquiler.setTotal(rs.getInt(3));
			alquiler.setEstado(rs.getBoolean(4));
			
			ConexionSql.closeConnection(cn);
			return alquiler;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Alquiler> ObtenerTodos(int idreserva) {
		
		ArrayList<Alquiler> lista = new ArrayList<Alquiler>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM alquileres WHERE idreserva = " + idreserva;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {

				Alquiler alquiler = new Alquiler();
				alquiler.setId(rs.getInt(1));
				alquiler.setReserva(new ReservaDao().Obtener(rs.getInt(2)));
				alquiler.setTotal(rs.getInt(3));
				alquiler.setEstado(rs.getBoolean(4));
				lista.add(alquiler);
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
