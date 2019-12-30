package IDao;
import java.util.ArrayList;
import entidades.Usuario;

public interface IUsuarioDao {

	boolean Agregar(Usuario usuario);
	boolean Modificar(Usuario usuario);
	boolean Eliminar(int id);
	Usuario Obtener(int id);
	ArrayList<Usuario> ObtenerTodos();
}
