package entidades;

public class Fecha {

	private int dia;
	private int mes;
	private int año;
	
	public Fecha() {
		
	}
	
	public Fecha(int dia, int mes, int año) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}
	
	public Fecha(String fecha) {
		this.dia = Integer.parseInt(fecha.split("-")[2]);
		this.mes = Integer.parseInt(fecha.split("-")[1]);
		this.año = Integer.parseInt(fecha.split("-")[0]);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String toDate() {
		return año + "-" + mes + "-" + dia;
	}
	
	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", año=" + año + "]";
	}
}
