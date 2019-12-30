package idao;
import java.util.ArrayList;
import entidades.Equipo;;

public interface IEquipo {

	boolean Agregar(Equipo equipo);
	boolean Modificar(Equipo equipo);
	boolean Eliminar(int id);
	Equipo Obtener(int id);
	ArrayList<Equipo> ObtenerTodos();
}
