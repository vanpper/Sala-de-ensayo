package idao;

import java.util.ArrayList;

import entidades.Venta;

public interface IVentaDao {

	boolean Agregar(Venta venta);
	boolean Modificar(Venta venta);
	boolean Eliminar(int idventa);
	boolean Restaurar(int idventa);
	Venta Obtener(int idventa);
	ArrayList<Venta> ObtenerTodas(int idreserva);
}
