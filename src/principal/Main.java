package principal;

import java.sql.Connection;

import dao.BandaDao;
import entidades.Banda;
import entidades.ConexionSQL;
import idao.IBandaDao;

public class Main {

	public static void main(String[] args) {
		
		IBandaDao bandaDao = new BandaDao();
		
		Banda banda = new Banda();
		banda.setId(7);
		banda.setNombre("almaAAA");
		banda.setEmail("almahotmail");
		banda.setTelefono("9999");
		
		bandaDao.Eliminar(7);
	}

}
