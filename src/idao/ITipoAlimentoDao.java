package idao;
import java.util.ArrayList;
import entidades.TipoAlimento;

public interface ITipoAlimentoDao {

	TipoAlimento Obtener(int id);
	ArrayList<TipoAlimento> ObtenerTodos();
}
