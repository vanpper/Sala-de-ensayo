package principal;

import java.sql.Connection;

import dao.AlimentoDao;
import dao.BandaDao;
import dao.TipoAlimentoDao;
import dao.TipoEquipoDao;
import dao.UsuarioDao;
import entidades.Alimento;
import entidades.Banda;
import entidades.ConexionSQL;
import entidades.TipoEquipo;
import entidades.Usuario;
import idao.IAlimentoDao;
import idao.IBandaDao;
import idao.ITipoEquipoDao;
import idao.IUsuarioDao;

public class Main {

	public static void main(String[] args) {
		
		IAlimentoDao dao = new AlimentoDao();
		
		Alimento a = new Alimento();
		a.setId(1);
		a.setNombre("super pancho");
		a.setDescripcion("con panceta, aderesos");
		a.setTipo(new TipoAlimentoDao().Obtener(6));
		a.setPrecio(50);
		
		for(Alimento ali : dao.ObtenerTodos()) {
			System.out.println(ali.toString());
		}
	}

}
