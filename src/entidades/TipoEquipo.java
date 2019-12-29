package entidades;

public class TipoEquipo {

	private int id;
	private String descripcion;
	
	public TipoEquipo() {
		
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
		return "TipoEquipo [id=" + id + ", descripcion=" + descripcion + "]";
	}
}
