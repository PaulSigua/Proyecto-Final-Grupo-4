package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.dao.CategoriaDao;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Categorias;
import ec.edu.ups.ppw63.facturacionTechShop.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCategorias {
	
	@Inject
	private CategoriaDao daoCategoria;
	
	public List<Categorias> getCategorias(){
		return daoCategoria.getAll();
	}
	
	public Categorias getCategoriaPorId(int codigo){
		return daoCategoria.getCategoriaPorId(codigo);
}

}
