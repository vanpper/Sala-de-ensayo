package idao;
import java.util.ArrayList;
import entidades.Equipo;;

public interface IEquipoDao {

	boolean Agregar(Equipo equipo);
	boolean Modificar(Equipo equipo);
	boolean Eliminar(int id);
	boolean Restaurar(int id);
	Equipo Obtener(int id);
	ArrayList<Equipo> ObtenerTodos();
}
