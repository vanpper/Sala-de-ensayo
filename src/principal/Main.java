package principal;

import java.sql.Connection;

import dao.AlimentoDao;
import dao.BandaDao;
import dao.EquipoDao;
import dao.ServicioDao;
import dao.TipoAlimentoDao;
import dao.TipoEquipoDao;
import dao.UsuarioDao;
import entidades.Alimento;
import entidades.Banda;
import entidades.ConexionSQL;
import entidades.Equipo;
import entidades.Servicio;
import entidades.TipoEquipo;
import entidades.Usuario;
import idao.IAlimentoDao;
import idao.IBandaDao;
import idao.IEquipoDao;
import idao.IServicioDao;
import idao.ITipoEquipoDao;
import idao.IUsuarioDao;

public class Main {

	public static void main(String[] args) {
		
		IServicioDao dao = new ServicioDao();
		
		Servicio s = new Servicio();
		s.setDescripcion("grabacionnn");
		s.setPrecio(300);
		s.setId(1);
		
		for(Servicio serv : dao.ObtenerTodos()) {
			System.out.println(serv.toString());
		}
	}

}
