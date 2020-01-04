package inegocio;
import java.util.ArrayList;
import entidades.Alimento;

public interface IAlimentoNeg {

	boolean Agregar(Alimento alimento);
	boolean Modificar(Alimento alimento);
	boolean Eliminar(int id);
	boolean Restaurar(int id);
	Alimento Obtener(int id);
	ArrayList<Alimento> ObtenerTodos();
}
