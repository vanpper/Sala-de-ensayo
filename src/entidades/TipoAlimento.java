package entidades;

public class TipoAlimento {

	private int id;
	private String descripcion;
	
	public TipoAlimento() {
		
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

	@Override
	public String toString() {
		return "TipoAlimento [id=" + id + ", descripcion=" + descripcion + "]";
	}
}
