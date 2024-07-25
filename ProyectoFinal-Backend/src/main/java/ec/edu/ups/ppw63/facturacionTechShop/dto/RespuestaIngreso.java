package ec.edu.ups.ppw63.facturacionTechShop.dto;

import ec.edu.ups.ppw63.facturacionTechShop.model.Cliente;

public class RespuestaIngreso {

	private boolean inicioExitoso;
	private Cliente cliente;
	
	public boolean isInicioExitoso() {
		return inicioExitoso;
	}
	public void setInicioExitoso(boolean inicioExitoso) {
		this.inicioExitoso = inicioExitoso;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
	
}
