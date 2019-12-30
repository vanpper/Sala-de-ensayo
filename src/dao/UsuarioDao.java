package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.ConexionSQL;
import entidades.Usuario;
import idao.IUsuarioDao;

public class UsuarioDao implements IUsuarioDao{

	@Override
	public boolean Agregar(Usuario usuario) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "INSERT INTO usuarios("
						+ "nombre,"
						+ "apellido"
						+ "telefono"
						+ "email"
						+ "contraseña) VALUES(?,?,?,?,?)";
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getTelefono());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getContraseña());
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
	public boolean Modificar(Usuario usuario) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "UPDATE usuarios SET nombre = ?,"
						+ "apellido = ?,"
						+ "telefono = ?,"
						+ "contraseña = ?,"
						+ "estado = ? WHERE idusuario = " + usuario.getId();
		
		try {
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getTelefono());
			pst.setString(4, usuario.getContraseña());
			pst.setBoolean(5, usuario.getEstado());
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
		String query = "UPDATE usuarios SET estado = 0 WHERE idusuario = " + id;
		
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
		String query = "UPDATE usuarios SET estado = 1 WHERE idusuario = " + id;
		
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
	public Usuario Obtener(int id) {
		
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM usuarios WHERE idusuario = " + id;
		
		try {
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			rs.next();
			
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt(1));
			usuario.setNombre(rs.getString(2));
			usuario.setApellido(rs.getString(3));
			usuario.setTelefono(rs.getString(4));
			usuario.setEmail(rs.getString(5));
			usuario.setContraseña(rs.getString(6));
			usuario.setEstado(rs.getBoolean(7));
			
			ConexionSQL.closeConnection(cn);
			return usuario;
		}
		catch (Exception e) {
			e.printStackTrace();
			ConexionSQL.closeConnection(cn);
			return null;
		}
	}

	@Override
	public ArrayList<Usuario> ObtenerTodos() {
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection cn = ConexionSQL.getOpenConnection();
		String query = "SELECT * FROM usuarios ORDER BY nombre + apellido ASC";
		
		try {
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			
			while(rs.next()) {
			
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellido(rs.getString(3));
				usuario.setTelefono(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setContraseña(rs.getString(6));
				usuario.setEstado(rs.getBoolean(7));
				lista.add(usuario);
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
