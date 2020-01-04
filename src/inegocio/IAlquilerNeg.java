package inegocio;

import java.util.ArrayList;

import entidades.Alquiler;

public interface IAlquilerNeg {

	boolean Agregar(Alquiler alquiler);
	boolean Modificar(Alquiler alquiler);
	boolean Eliminar(int idalquiler);
	boolean Restaurar(int idalquiler);
	Alquiler Obtener(int idalquiler);
	ArrayList<Alquiler> ObtenerTodos(int idreserva);
}
