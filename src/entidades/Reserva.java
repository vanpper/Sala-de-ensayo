package entidades;

import java.util.ArrayList;

public class Reserva {

	private int id;
	private Banda banda;
	private Sala sala;
	private Fecha fecha;
	private int horaDesde;
	private int horaHasta;
	private int precio;
	private ArrayList<Alimento> alimentos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Servicio> servicios;
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
	
	public ArrayList<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(ArrayList<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", banda=" + banda + ", sala=" + sala + ", fecha=" + fecha + ", horaDesde="
				+ horaDesde + ", horaHasta=" + horaHasta + ", precio=" + precio + ", alimentos=" + alimentos
				+ ", equipos=" + equipos + ", servicios=" + servicios + ", estado=" + estado + "]";
	}
}
