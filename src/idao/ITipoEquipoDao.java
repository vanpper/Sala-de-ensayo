package idao;
import java.util.ArrayList;
import entidades.TipoEquipo;;

public interface ITipoEquipoDao {

	TipoEquipo Obtener(int id);
	ArrayList<TipoEquipo> ObtenerTodos();
}
