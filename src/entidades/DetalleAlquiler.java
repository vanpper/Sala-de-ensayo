package entidades;

public class DetalleAlquiler {

	private Equipo equipo;
	private int cantidad;
	private int precio;
	private int subtotal;
	
	public DetalleAlquiler() {
		
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "DetalleAlquiler [equipo=" + equipo + ", cantidad=" + cantidad + ", precio=" + precio + ", subtotal="
				+ subtotal + "]";
	}
	
}
