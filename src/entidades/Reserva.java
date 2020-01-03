package entidades;

public class Reserva {

	private int id;
	private Banda banda;
	private Sala sala;
	private Fecha fecha;
	private int horaDesde;
	private int horaHasta;
	private int precio;
	private boolean estado;
	
	public Reserva() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public int getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(int horaDesde) {
		this.horaDesde = horaDesde;
	}

	public int getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(int horaHasta) {
		this.horaHasta = horaHasta;
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
		return "Reserva [id=" + id + ", banda=" + banda + ", sala=" + sala + ", fecha=" + fecha + ", horaDesde="
				+ horaDesde + ", horaHasta=" + horaHasta + ", precio=" + precio + ", estado=" + estado + "]";
	}
	
	
}
