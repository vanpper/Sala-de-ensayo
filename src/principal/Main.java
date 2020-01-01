package principal;

import java.sql.Connection;

import dao.VentaDao;
import entidades.Reserva;
import entidades.Venta;
import idao.IVentaDao;

public class Main {

	public static void main(String[] args) {
		
		IVentaDao dao = new VentaDao();
		
		Reserva reserva = new Reserva();
		reserva.setId(1);
		
		Venta venta = new Venta();
		venta.setId(1);
		venta.setReserva(reserva);
		venta.setTotal(1500);
		
		for(Venta v : dao.ObtenerTodas(1)) {
			System.out.println(v.toString());
		}
	}

}
