package negocio;
import java.util.ArrayList;
import dao.AlimentoDao;
import entidades.Alimento;
import idao.IAlimentoDao;
import inegocio.IAlimentoNeg;

public class AlimentoNeg implements IAlimentoNeg{

	private IAlimentoDao dao = new AlimentoDao();
	
	@Override
	public boolean Agregar(Alimento alimento) {
		return dao.Agregar(alimento);
	}

	@Override
	public boolean Modificar(Alimento alimento) {
		return dao.Modificar(alimento);
	}

	@Override
	public boolean Eliminar(int id) {
		return dao.Eliminar(id);
	}

	@Override
	public boolean Restaurar(int id) {
		return dao.Restaurar(id);
	}

	@Override
	public Alimento Obtener(int id) {
		return dao.Obtener(id);
	}

	@Override
	public ArrayList<Alimento> ObtenerTodos() {
		return dao.ObtenerTodos();
	}

}
