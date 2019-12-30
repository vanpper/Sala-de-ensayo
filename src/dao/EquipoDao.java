package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entidades.ConexionSql;
import entidades.Equipo;
import idao.IEquipoDao;

public class EquipoDao implements IEquipoDao{

	@Override
	public boolean Agregar(Equipo equipo) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "INSERT INTO equipos("
						+ "nombre,"
						+ "descripcion,"
						+ "idtipoequipo,"
						+ "precio) VALUES(?,?,?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, equipo.getNombre());
			pst.setString(2, equipo.getDescripcion());
			pst.setInt(3, equipo.getTipo().getId());
			pst.setInt(4, equipo.getPrecio());
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
	public boolean Modificar(Equipo equipo) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "UPDATE equipos SET "
						+ "nombre = ?,"
						+ "descripcion = ?,"
						+ "idtipoequipo = ?,"
						+ "precio = ?,"
						+ "estado = ? WHERE idequipo = " + equipo.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, equipo.getNombre());
			pst.setString(2, equipo.getDescripcion());
			pst.setInt(3, equipo.getTipo().getId());
			pst.setInt(4, equipo.getPrecio());
			pst.setBoolean(5, equipo.getEstado());
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
		String query = "UPDATE equipos SET estado = 0 WHERE idequipo = " + id;
		
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
		String query = "UPDATE equipos SET estado = 1 WHERE idequipo = " + id;
		
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
	public Equipo Obtener(int id) {
		
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM equipos WHERE idequipo = " + id;
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Equipo equipo = new Equipo();
			equipo.setId(rs.getInt(1));
			equipo.setNombre(rs.getString(2));
			equipo.setDescripcion(rs.getString(3));
			equipo.setTipo(new TipoEquipoDao().Obtener(rs.getInt(4)));
			equipo.setPrecio(rs.getInt(5));
			equipo.setEstado(rs.getBoolean(6));
			
			ConexionSql.closeConnection(cn);
			return equipo;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSql.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Equipo> ObtenerTodos() {
		
		ArrayList<Equipo> lista = new ArrayList<Equipo>();
		Connection cn = ConexionSql.getOpenConnection();
		String query = "SELECT * FROM equipos ORDER BY nombre ASC";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				
				Equipo equipo = new Equipo();
				equipo.setId(rs.getInt(1));
				equipo.setNombre(rs.getString(2));
				equipo.setDescripcion(rs.getString(3));
				equipo.setTipo(new TipoEquipoDao().Obtener(rs.getInt(4)));
				equipo.setPrecio(rs.getInt(5));
				equipo.setEstado(rs.getBoolean(6));
				lista.add(equipo);
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
