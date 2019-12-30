package principal;

import java.sql.Connection;

import Dao.BandaDao;
import IDao.IBandaDao;
import entidades.Banda;
import entidades.ConexionSQL;

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
