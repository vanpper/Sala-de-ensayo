package negocio;

import java.util.ArrayList;

import dao.AlquilerDao;
import dao.DetalleAlquilerDao;
import entidades.Alimento;
import entidades.Alquiler;
import entidades.DetalleAlquiler;
import idao.IAlquilerDao;
import idao.IDetalleAlquilerDao;
import inegocio.IAlimentoNeg;
import inegocio.IAlquilerNeg;

public class AlquilerNeg implements IAlquilerNeg{

	private IAlquilerDao alquilerDao = new AlquilerDao();
	private IDetalleAlquilerDao detalleDao = new DetalleAlquilerDao();
	
	@Override
	public boolean Agregar(Alquiler alquiler) {
		
		
		
		if(!alquilerDao.Agregar(alquiler)) return false; //crear el alquiler
		
		Alquiler ultimo = alquilerDao.ObtenerUltimo(alquiler.getReserva().getId()); //obtener el alquiler agregado
		if(ultimo == null) return false;
		
		for(DetalleAlquiler detalle : alquiler.getDetalle()) { //recorrer los detalles e ir agregando
			
			if(!detalleDao.Agregar(ultimo.getId(), detalle)) return false; //comprobar si se pudo agregar cada detalle
		}
		
		return true;
	}
	
	@Override
	public boolean Modificar(Alquiler alquiler) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean Eliminar(int idalquiler) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean Restaurar(int idalquiler) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Alquiler Obtener(int idalquiler) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Alquiler> ObtenerTodos(int idreserva) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
