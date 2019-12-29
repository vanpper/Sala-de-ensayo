package entidades;

public class Servicio {

	private int id;
	private String descripcion;
	private int precio;
	private boolean estado;
	
	public Servicio() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", estado=" + estado
				+ "]";
	}
}
