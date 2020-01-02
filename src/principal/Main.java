package principal;

import java.sql.Connection;

import dao.AlimentoDao;
import dao.AlquilerDao;
import dao.DetalleAlquilerDao;
import dao.DetalleVentaDao;
import dao.EquipoDao;
import dao.ReservaDao;
import dao.VentaDao;
import entidades.Alquiler;
import entidades.DetalleAlquiler;
import entidades.DetalleVenta;
import entidades.Reserva;
import entidades.Venta;
import idao.IAlquilerDao;
import idao.IDetalleAlquilerDao;
import idao.IVentaDao;

public class Main {

	public static void main(String[] args) {
		
		IDetalleAlquilerDao dao = new DetalleAlquilerDao();
		
		DetalleAlquiler detalle = new DetalleAlquiler();
		detalle.setEquipo(new EquipoDao().Obtener(1));
		detalle.setCantidad(3);
		detalle.setPrecio(75);
		detalle.setSubtotal(225);
		
		dao.Eliminar(1, 1);
		
	}

}
