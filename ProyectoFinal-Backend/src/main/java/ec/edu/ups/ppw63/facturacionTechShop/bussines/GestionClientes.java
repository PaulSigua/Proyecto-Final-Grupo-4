package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.List;


import ec.edu.ups.ppw63.facturacionTechShop.dao.ClienteDao;
import ec.edu.ups.ppw63.facturacionTechShop.dto.Ingreso;
import ec.edu.ups.ppw63.facturacionTechShop.dto.RespuestaIngreso;
import ec.edu.ups.ppw63.facturacionTechShop.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class GestionClientes {

	@Inject
	private ClienteDao daoCliente;
	
	private boolean ingresoExitoso = false;
	private RespuestaIngreso ri;
	
	public RespuestaIngreso actualizarCliente(Cliente cliente) throws Exception {
		Cliente cli = daoCliente.getClienteEmail(cliente.getCorreo());
		if (cli != null){
			daoCliente.update(cliente);
			ingresoExitoso = true;
			ri = new RespuestaIngreso();
			ri.setCliente(cliente);
			ri.setInicioExitoso(ingresoExitoso);
			return ri;
		}else {
			throw new Exception("Cliente no existe");
		}
	}
	
	public void guardarClientes(Cliente cliente) {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null) {
			daoCliente.update(cliente);
		}else {
			daoCliente.insert(cliente);
		}
	}
	public Cliente getClientePorId(int codigo){
		return daoCliente.getClientePorId(codigo);
}
	public void borrarCliente(int codigo) {
		daoCliente.remove(codigo);
	}
	
	public List<Cliente> getClientes(){
		return daoCliente.getAll();
	}
	
	public RespuestaIngreso verificacionCredenciales(Ingreso ingreso) throws Exception{
		Cliente c = daoCliente.getClienteEmail(ingreso.getEmail() );
		if((c != null) && (c.getContrasenia().equals(ingreso.getClave()))) {
			Cliente nc = new Cliente(c.getPrimerNombre(), c.getPrimerApellido(), c.getCorreo());
			nc.setCodigo(c.getCodigo());
			ingresoExitoso = true;
			ri = new RespuestaIngreso();
			ri.setInicioExitoso(ingresoExitoso);
			ri.setCliente(c);
			return ri;
		}
		else {
			throw new Exception("Usuario no encontrado");
		}
	}
	
}
