package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import IDao.IBandaDao;
import entidades.Banda;
import entidades.ConexionSQL;

public class BandaDao implements IBandaDao{

	@Override
	public boolean Agregar(Banda banda) {
		
		Connection conexion = ConexionSQL.getOpenConnection();
		String query = "INSERT INTO bandas(nombre, telefono, email) VALUES(?,?,?)";
		
		try {
			
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.setString(1, banda.getNombre());
			pst.setString(2, banda.getTelefono());
			pst.setString(3, banda.getEmail());
			pst.executeUpdate();
			
			ConexionSQL.closeConnection(conexion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(conexion);
			return false;
		}
	}

	@Override
	public boolean Modificar(Banda banda) {

		Connection conexion = ConexionSQL.getOpenConnection();
		String query = "UPDATE bandas SET nombre = ?, telefono = ?, email = ?, estado = ? WHERE idbanda = " + banda.getId();
		
		try {
			
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.setString(1, banda.getNombre());
			pst.setString(2, banda.getTelefono());
			pst.setString(3, banda.getEmail());
			pst.setBoolean(4, banda.getEstado());
			pst.executeUpdate();
			
			ConexionSQL.closeConnection(conexion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(conexion);
			return false;
		}
	}

	@Override
	public boolean Eliminar(int id) {
		
		Connection conexion = ConexionSQL.getOpenConnection();
		String query = "UPDATE bandas SET estado = 0 WHERE idbanda = " + id;
		
		try {
			
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.executeUpdate();
			
			ConexionSQL.closeConnection(conexion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(conexion);
			return false;
		}
	}

	@Override
	public Banda Obtener(int id) {
		
		Connection conexion = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM bandas WHERE idbanda = " + id;
		
		try {
			
			PreparedStatement pst = conexion.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Banda banda = new Banda();
			banda.setId(rs.getInt(1));
			banda.setNombre(rs.getString(2));
			banda.setTelefono(rs.getString(3));
			banda.setEmail(rs.getString(4));
			banda.setEstado(rs.getBoolean(5));
			
			ConexionSQL.closeConnection(conexion);
			return banda;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(conexion);
			return null;
		}
	}

	@Override
	public ArrayList<Banda> ObtenerTodas() {
		
		ArrayList<Banda> lista = new ArrayList<Banda>();
		Connection conexion = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM bandas ORDER BY nombre ASC";
		
		try {
			
			PreparedStatement pst = conexion.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
				Banda banda = new Banda();
				banda.setId(rs.getInt(1));
				banda.setNombre(rs.getString(2));
				banda.setTelefono(rs.getString(3));
				banda.setEmail(rs.getString(4));
				banda.setEstado(rs.getBoolean(5));
				lista.add(banda);
			}
			
			ConexionSQL.closeConnection(conexion);
			return lista;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(conexion);
			return null;
		}
	}

	@Override
	public boolean Restaurar(int id) {
		
		Connection conexion = ConexionSQL.getOpenConnection();
		String query = "UPDATE bandas SET estado = 1 WHERE idbanda = " + id;
		
		try {
			
			PreparedStatement pst = conexion.prepareStatement(query);
			pst.executeUpdate();
			
			ConexionSQL.closeConnection(conexion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(conexion);
			return false;
		}
	}

}
