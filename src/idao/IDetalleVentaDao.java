package idao;

import java.util.ArrayList;

import entidades.DetalleVenta;

public interface IDetalleVentaDao {

	boolean Agregar(int idventa, DetalleVenta detalle);
	boolean Modificar(int idventa, DetalleVenta detalle);
	boolean Eliminar(int idventa, int idalimento);
	DetalleVenta Obtener(int idventa, int idalimento);
	ArrayList<DetalleVenta> ObtenerTodos(int idventa);
}
