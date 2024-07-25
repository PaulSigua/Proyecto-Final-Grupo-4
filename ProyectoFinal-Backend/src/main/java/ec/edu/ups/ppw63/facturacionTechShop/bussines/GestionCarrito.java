package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.dao.CarritoDAO;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Detalles_Carrito;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCarrito {

	@Inject
	private CarritoDAO daoCarrito;
	
	public void actualizarCarrito(Carrito carrito) throws Exception {
		Carrito car = daoCarrito.read(carrito.getCodigo());
		if (car != null){
			daoCarrito.update(carrito);
		}else {
			throw new Exception("Carrito no existe");
		}
	}
	
	public void guardarCarritos(Carrito carrito) {
		System.out.println("Codigo: " + carrito.getCodigo());
		Carrito car = daoCarrito.read(carrito.getCodigo());
		if (car != null) {
			System.out.println("Este es: " + carrito);
			daoCarrito.update(carrito);
		}else {
			daoCarrito.insert(carrito);
		}
	}
	
	public Carrito getCarritoPorId(int codigo){
			return daoCarrito.getCarritoPorId(codigo);
	}
	
	public void borrarCarrito(int codigo) {
		daoCarrito.remove(codigo);
	}
	
	public List<Carrito> getCarritos(){
		return daoCarrito.getAll();
	}
	
	public void agregarDetalle(Detalles_Carrito detalleCarrito) throws Exception{
		System.out.println("El detalle es: " + detalleCarrito.getCodigoCarrito());
		Carrito carObtenido = getCarritoPorId(detalleCarrito.getCodigoCarrito());
		List<Detalles_Carrito> detallesExistentes = carObtenido.getDetalles();
		boolean encontroProducto = false;
		if (detallesExistentes.size() == 0) {
			System.out.println("Si entra aqui es por que esta mal");
			carObtenido.addDetalles(detalleCarrito);
			daoCarrito.update(carObtenido);
		}else {
			for (int i = 0; i < detallesExistentes.size(); i++) {
				System.out.println("Entro al for con: " + detallesExistentes.get(i).getCodigoProducto());
				if (detallesExistentes.get(i).getCodigoProducto() == detalleCarrito.getCodigoProducto()) {
					if(detalleCarrito.getCantidad() == 0) {
						detallesExistentes.remove(i);
						carObtenido.setDetalles(detallesExistentes);
						daoCarrito.update(carObtenido);
						encontroProducto = true;
					}else {
						System.out.println("Entro a la validacion porque: " + detalleCarrito.getCodigoProducto());
						detallesExistentes.get(i).setCantidad(detallesExistentes.get(i).getCantidad()+ detalleCarrito.getCantidad());
						carObtenido.setDetalles(detallesExistentes);
						daoCarrito.update(carObtenido);
						encontroProducto = true;
					}
					}
			}
			if (!encontroProducto) {
				System.out.println("No econtro nada en el for: ");
				carObtenido.addDetalles(detalleCarrito);
				daoCarrito.update(carObtenido);
			}
			encontroProducto = false;
		}
		
	}
	
	public Carrito getClientePorCliente(int codigo){
		return daoCarrito.getCarritoPorCliente(codigo);
	}
	
	public void limpiarDetalles(int codigoCarrito) throws Exception{
		Carrito carObtenido = getCarritoPorId(codigoCarrito);
		List<Detalles_Carrito> detallesExistentes = carObtenido.getDetalles();
		boolean encontroProducto = false;
		if (detallesExistentes.size() == 0) {
			System.out.println("Si entra aqui es por que esta mal");
		}else {
			carObtenido.getDetalles().clear();
			daoCarrito.update(carObtenido);
		}
		}
		
	}
