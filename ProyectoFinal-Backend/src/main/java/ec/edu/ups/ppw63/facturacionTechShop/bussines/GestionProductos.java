package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.dao.ProductosDao;
import ec.edu.ups.ppw63.facturacionTechShop.model.Productos;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProductos {

	@Inject
	private ProductosDao daoProducto;
	
	
	
	public void actualizarProducto(Productos producto) throws Exception {
		Productos pro = daoProducto.read(producto.getCodigo());
		if (pro != null){
			daoProducto.update(producto);
		}else {
			throw new Exception("Producto no existe");
		}
	}
	
	public void guardarProductos(Productos producto) {
		System.out.println("Codigo: " + producto.getCodigo());
		Productos pro = daoProducto.read(producto.getCodigo());
		if (pro != null) {
			System.out.println("Este es: " + producto);
			daoProducto.update(producto);
		}else {
			daoProducto.insert(producto);
		}
	}
	
	public void borrarProducto(int codigo) {
		daoProducto.remove(codigo);
	}
	
	public List<Productos> getProductos(){
		return daoProducto.getAll();
	}
	
	public Productos getProductoPorId(int codigo){
		return daoProducto.getProductoPorId(codigo);
	}
	
	public List<Productos> getOfertas(){
		return daoProducto.getOfertas();
	}
	
	public List<Productos> buscarPorNombre(String nombre){
		return daoProducto.buscarPorNombre(nombre);
	}

}
