package entidades;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

	private int dia;
	private int mes;
	private int año;
	
	public Fecha() {
		
	}
	
	public Fecha(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		this.dia = calendar.get(Calendar.DAY_OF_MONTH);
		this.mes = calendar.get(Calendar.MONTH) + 1;
		this.mes = calendar.get(Calendar.YEAR);
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
