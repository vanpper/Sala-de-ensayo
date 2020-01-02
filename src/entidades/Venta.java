package entidades;

import java.util.ArrayList;

public class Venta {

	private int id;
	private Reserva reserva;
	private ArrayList<DetalleVenta> detalle;
	private int total;
	private boolean estado;
	
	public Venta() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public ArrayList<DetalleVenta> getDetalle() {
		return detalle;
	}

	public void setDetalle(ArrayList<DetalleVenta> detalle) {
		this.detalle = detalle;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", reserva=" + reserva + ", detalle=" + detalle + ", total=" + total + ", estado="
				+ estado + "]";
	}

}
