package principal;

import java.sql.Connection;

import dao.BandaDao;
import dao.TipoEquipoDao;
import dao.UsuarioDao;
import entidades.Banda;
import entidades.ConexionSQL;
import entidades.TipoEquipo;
import entidades.Usuario;
import idao.IBandaDao;
import idao.ITipoEquipoDao;
import idao.IUsuarioDao;

public class Main {

	public static void main(String[] args) {
		
		ITipoEquipoDao dao = new TipoEquipoDao();
		
		for(TipoEquipo e : dao.ObtenerTodos()) {
			System.out.println(e.toString());
		}
	}

}
