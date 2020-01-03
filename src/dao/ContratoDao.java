package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.ConexionSql;
import entidades.Contrato;
import idao.IContratoDao;

public class ContratoDao implements IContratoDao{

	@Override
	public boolean Agregar(Contrato contrato) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO contratos(idreserva, total) VALUES(?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, contrato.getReserva().getId());
			pst.setInt(2, contrato.getTotal());
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
	public boolean Modificar(Contrato contrato) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE contratos SET "
						+ "total = ?,"
						+ "estado = ? WHERE idcontrato = " + contrato.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, contrato.getTotal());
			pst.setBoolean(2, contrato.getEstado());
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
	public boolean Eliminar(int idcontrato) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE contratos SET estado = 0 WHERE idcontrato = " + idcontrato;
		
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
	public boolean Restaurar(int idcontrato) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE contratos SET estado = 1 WHERE idcontrato = " + idcontrato;
		
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
	public Contrato Obtener(int idcontrato) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM contratos WHERE idcontrato = " + idcontrato;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Contrato contrato = new Contrato();
			contrato.setId(rs.getInt(1));
			contrato.setReserva(new ReservaDao().Obtener(rs.getInt(2)));
			contrato.setTotal(rs.getInt(3));
			contrato.setEstado(rs.getBoolean(4));
			
			ConexionSql.closeConnection(cn);
			return contrato;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Contrato> ObtenerTodos(int idreserva) {
		
		ArrayList<Contrato> lista = new ArrayList<Contrato>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM contratos WHERE idreserva = " + idreserva;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {

				Contrato contrato = new Contrato();
				contrato.setId(rs.getInt(1));
				contrato.setReserva(new ReservaDao().Obtener(rs.getInt(2)));
				contrato.setTotal(rs.getInt(3));
				contrato.setEstado(rs.getBoolean(4));
				lista.add(contrato);
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
