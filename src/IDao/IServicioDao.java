package IDao;
import java.util.ArrayList;
import entidades.Servicio;

public interface IServicioDao {

	boolean Agregar(Servicio servicio);
	boolean Modificar(Servicio servicio);
	boolean Eliminar(int id);
	Servicio Obtener(int id);
	ArrayList<Servicio> ObtenerTodos();
}
