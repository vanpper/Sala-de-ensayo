package idao;
import java.util.ArrayList;
import entidades.Contrato;

public interface IContratoDao {

	boolean Agregar(Contrato contrato);
	boolean Modificar(Contrato contrato);
	boolean Eliminar(int idcontrato);
	boolean Restaurar(int idcontrato);
	Contrato Obtener(int idcontrato);
	ArrayList<Contrato> ObtenerTodos(int idreserva);
	
}
