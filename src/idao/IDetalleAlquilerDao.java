package idao;

import java.util.ArrayList;

import entidades.DetalleAlquiler;

public interface IDetalleAlquilerDao {

	boolean Agregar(int idalquiler, DetalleAlquiler detalle);
	boolean Modificar(int idalquiler, DetalleAlquiler detalle);
	boolean Eliminar(int idalquiler, int idequipo);
	DetalleAlquiler Obtener(int idalquiler, int idequipo);
	ArrayList<DetalleAlquiler> ObtenerTodos(int idalquiler);
}
