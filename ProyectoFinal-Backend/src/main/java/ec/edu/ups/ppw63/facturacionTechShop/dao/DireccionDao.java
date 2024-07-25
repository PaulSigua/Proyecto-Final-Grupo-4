package ec.edu.ups.ppw63.facturacionTechShop.dao;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.model.Direcciones;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DireccionDao {

	@PersistenceContext
	private EntityManager em;

	public void insert(Direcciones direcciones) {
		em.persist(direcciones);
	}
		
	public void update(Direcciones direcciones) {
		em.merge(direcciones);	
	}

	public void remove(int codigo) {
		Direcciones direcciones = em.find(Direcciones.class, codigo);
		em.remove(direcciones);
	}
	
	public Direcciones read(int codigo) {
		Direcciones direcciones = em.find(Direcciones.class, codigo);
		return direcciones;
	}
	
	public List<Direcciones> getAll(){
		String jpql = "SELECT c FROM Direcciones c"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Direcciones.class);
		return q.getResultList();
	}
	
	public Direcciones getDireccionesPorId(int codigo) {
		String jpql = "SELECT c FROM Direcciones c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Direcciones.class);
		q.setParameter("codigo", codigo);
		List<Direcciones> direccioness = q.getResultList();
		if (direccioness.size() > 0)
			return direccioness.get(0);
		return null;
		}
	
	public Direcciones getDireccionPorCliente(int codigoCliente) {
	    String jpql = "SELECT c FROM Direcciones c WHERE c.cliente.codigo = :codigo";
	    Query q = em.createQuery(jpql, Direcciones.class);
	    q.setParameter("codigo", codigoCliente);
	    List<Direcciones> direccionesList = q.getResultList();
	    if (!direccionesList.isEmpty()) {
	        return direccionesList.get(0);
	    }
	    return null;
	}
}
