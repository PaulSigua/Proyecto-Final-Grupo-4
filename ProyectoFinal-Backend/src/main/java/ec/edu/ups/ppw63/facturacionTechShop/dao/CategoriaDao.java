package ec.edu.ups.ppw63.facturacionTechShop.dao;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Categorias;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CategoriaDao {

	@PersistenceContext
	private EntityManager em;

	public void insert(Categorias categorias) {
		em.persist(categorias);
	}
		
	public void update(Categorias categorias) {
		em.merge(categorias);	
	}

	public void remove(int codigo) {
		Categorias categorias = em.find(Categorias.class, codigo);
		em.remove(categorias);
	}
	
	public Categorias read(int codigo) {
		Categorias categorias = em.find(Categorias.class, codigo);
		return categorias;
	}
	
	public List<Categorias> getAll(){
		String jpql = "SELECT c FROM Categorias c"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Categorias.class);
		return q.getResultList();
	}
	
	public Categorias getCategoriaPorId(int codigo) {
		String jpql = "SELECT c FROM Categorias c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Categorias.class);
		q.setParameter("codigo", codigo);
		List<Categorias> cats= q.getResultList();
		if (cats.size() > 0)
			return cats.get(0);
		return null;
	}
	
}
