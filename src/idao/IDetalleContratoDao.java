package idao;

import java.util.ArrayList;

import entidades.DetalleContrato;

public interface IDetalleContratoDao {

	boolean Agregar(int idcontrato, DetalleContrato detalle);
	boolean Modificar(int idcontrato, DetalleContrato detalle);
	boolean Eliminar(int idcontrato, int idservicio);
	DetalleContrato Obtener(int idcontrato, int idservicio);
	ArrayList<DetalleContrato> ObtenerTodos(int idcontrato);
	
}
