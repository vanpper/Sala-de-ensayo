package principal;

import java.sql.Connection;

import dao.AlimentoDao;
import dao.BandaDao;
import dao.EquipoDao;
import dao.SalaDao;
import dao.ServicioDao;
import dao.TipoAlimentoDao;
import dao.TipoEquipoDao;
import dao.UsuarioDao;
import entidades.Alimento;
import entidades.Banda;
import entidades.ConexionSql;
import entidades.Equipo;
import entidades.Sala;
import entidades.Servicio;
import entidades.TipoEquipo;
import entidades.Usuario;
import idao.IAlimentoDao;
import idao.IBandaDao;
import idao.IEquipoDao;
import idao.ISalaDao;
import idao.IServicioDao;
import idao.ITipoEquipoDao;
import idao.IUsuarioDao;

public class Main {

	public static void main(String[] args) {
		
		ISalaDao dao = new SalaDao();
		
		Sala s = new Sala();
		s.setDescripcion("full");
		s.setNombre("sala1");
		s.setPrecio(4000);
		s.setId(1);
		
		for(Sala sala : dao.ObtenerTodas()) {
			System.out.println(sala.toString());
		}
	}

}
