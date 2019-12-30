package IDao;
import java.util.ArrayList;
import entidades.Banda;

public interface IBandaDao {

	boolean Agregar(Banda banda);
	boolean Modificar(Banda banda);
	boolean Eliminar(int id);
	boolean Restaurar(int id);
	Banda Obtener(int id);
	ArrayList<Banda> ObtenerTodas();
}
