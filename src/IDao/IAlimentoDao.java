package IDao;
import java.util.ArrayList;
import entidades.Alimento;;

public interface IAlimentoDao {

	boolean Agregar(Alimento alimento);
	boolean Modificar(Alimento alimento);
	boolean Eliminar(int id);
	Alimento Obtener(int id);
	ArrayList<Alimento> ObtenerTodos();
}
