package entidades;

public class DetalleVenta {

	private Alimento alimento;
	private int cantidad;
	private int precio;
	private int subtotal;
	
	public DetalleVenta() {
		
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
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
		return "DetalleVenta [alimento=" + alimento + ", cantidad=" + cantidad + ", precio=" + precio + ", subtotal="
				+ subtotal + "]";
	}
	
}
