package idao;
import java.util.ArrayList;
import entidades.Sala;;

public interface ISalaDao {

	boolean Agregar(Sala sala);
	boolean Modificar(Sala sala);
	boolean Eliminar(int id);
	Sala Obtener(int id);
	ArrayList<Sala> ObtenerTodas();
}
