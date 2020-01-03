package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entidades.ConexionSql;
import entidades.DetalleContrato;
import idao.IDetalleContratoDao;

public class DetalleContratoDao implements IDetalleContratoDao{

	@Override
	public boolean Agregar(int idcontrato, DetalleContrato detalle) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO detallecontratos VALUES(?,?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, idcontrato);
			pst.setInt(2, detalle.getServicio().getId());
			pst.setInt(3, detalle.getTotal());
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
	public boolean Modificar(int idcontrato, DetalleContrato detalle) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE detallecontratos SET total = ? WHERE idcontrato = ? AND idservicio = ?";

		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, detalle.getTotal());
			pst.setInt(2, idcontrato);
			pst.setInt(3, detalle.getServicio().getId());
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
	public boolean Eliminar(int idcontrato, int idservicio) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "DELETE FROM detallecontratos WHERE idcontrato = ? AND idservicio = ?";

		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, idcontrato);
			pst.setInt(2, idservicio);
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
	public DetalleContrato Obtener(int idcontrato, int idservicio) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM detallecontratos WHERE idcontrato = " + idcontrato + " AND idservicio = " + idservicio;

		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			DetalleContrato detalle = new DetalleContrato();
			detalle.setServicio(new ServicioDao().Obtener(rs.getInt(2)));
			detalle.setTotal(rs.getInt(3));
			
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
	public ArrayList<DetalleContrato> ObtenerTodos(int idcontrato) {
		
		ArrayList<DetalleContrato> lista = new ArrayList<DetalleContrato>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM detallecontratos WHERE idcontrato = " + idcontrato;

		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				DetalleContrato detalle = new DetalleContrato();
				detalle.setServicio(new ServicioDao().Obtener(rs.getInt(2)));
				detalle.setTotal(rs.getInt(3));
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
