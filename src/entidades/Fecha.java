package entidades;

public class Fecha {

	private int dia;
	private int mes;
	private int a�o;
	
	public Fecha() {
		
	}
	
	public Fecha(int dia, int mes, int a�o) {
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
	}
	
	public Fecha(String fecha) {
		this.dia = Integer.parseInt(fecha.split("-")[2]);
		this.mes = Integer.parseInt(fecha.split("-")[1]);
		this.a�o = Integer.parseInt(fecha.split("-")[0]);
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

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public String toDate() {
		return a�o + "-" + mes + "-" + dia;
	}
	
	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", a�o=" + a�o + "]";
	}
}
