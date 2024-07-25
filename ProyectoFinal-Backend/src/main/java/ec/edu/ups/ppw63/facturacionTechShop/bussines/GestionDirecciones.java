package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.List;



import ec.edu.ups.ppw63.facturacionTechShop.dao.DireccionDao;
import ec.edu.ups.ppw63.facturacionTechShop.dto.Ingreso;
import ec.edu.ups.ppw63.facturacionTechShop.dto.RespuestaIngreso;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Direcciones;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class GestionDirecciones {

	@Inject
	private DireccionDao daoDirecciones;
	
	public void actualizarDirecciones(Direcciones direcciones) throws Exception {
		Direcciones dir = daoDirecciones.read(direcciones.getCodigo());
		if (dir != null){
			daoDirecciones.update(direcciones);
		}else {
			throw new Exception("Direcciones no existe");
		}
	}
	
	public void guardarDireccioness(Direcciones direcciones) {
		System.out.println("Codigo: " + direcciones.getCodigo());
		Direcciones dir = daoDirecciones.read(direcciones.getCodigo());
		if (dir != null) {
			System.out.println("Este es: " + direcciones);
			daoDirecciones.update(direcciones);
		}else {
			daoDirecciones.insert(direcciones);
		}
	}
	
	
	public Direcciones getDireccionesPorId(int codigo){
			return daoDirecciones.getDireccionesPorId(codigo);
	}
	
	public void borrarDirecciones(int codigo) {
		daoDirecciones.remove(codigo);
	}
	
	public List<Direcciones> getDireccioness(){
		return daoDirecciones.getAll();
	}
	
	public Direcciones getDireccionPorCliente(int codigo){
		return daoDirecciones.getDireccionPorCliente(codigo);
	}
}
