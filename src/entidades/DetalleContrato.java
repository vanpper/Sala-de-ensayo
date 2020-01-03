package entidades;

public class DetalleContrato {

	private Servicio servicio;
	private int total;
	
	public DetalleContrato() {
		
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DetalleContrato [servicio=" + servicio + ", total=" + total + "]";
	}
	
}
