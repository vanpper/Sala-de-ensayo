package IDao;
import java.util.ArrayList;
import entidades.Reserva;;

public interface IReservaDao {

	boolean Agregar(Reserva reserva);
	boolean Modificar(Reserva reserva);
	boolean Eliminar(int id);
	Reserva Obtener(int id);
	ArrayList<Reserva> ObtenerTodas();
}
