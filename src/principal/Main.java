package principal;

import java.sql.Connection;

import dao.AlimentoDao;
import dao.BandaDao;
import dao.EquipoDao;
import dao.TipoAlimentoDao;
import dao.TipoEquipoDao;
import dao.UsuarioDao;
import entidades.Alimento;
import entidades.Banda;
import entidades.ConexionSQL;
import entidades.Equipo;
import entidades.TipoEquipo;
import entidades.Usuario;
import idao.IAlimentoDao;
import idao.IBandaDao;
import idao.IEquipoDao;
import idao.ITipoEquipoDao;
import idao.IUsuarioDao;

public class Main {

	public static void main(String[] args) {
		
		IEquipoDao dao = new EquipoDao();
		
		Equipo e = new Equipo();
		
		e.setId(1);
		e.setNombre("6505");
		e.setPrecio(1000);
		e.setTipo(new TipoEquipoDao().Obtener(4));
		
		for(Equipo eq : dao.ObtenerTodos()) {
			System.out.println(eq.toString());
		}
	}

}
