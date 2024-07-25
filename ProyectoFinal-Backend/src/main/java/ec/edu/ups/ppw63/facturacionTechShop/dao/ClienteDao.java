package ec.edu.ups.ppw63.facturacionTechShop.dao;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDao {

	@PersistenceContext
	private EntityManager em;

	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
		
	public void update(Cliente cliente) {
		em.merge(cliente);	
	}

	public void remove(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		em.remove(cliente);
	}
	
	public Cliente read(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		return cliente;
	}
	
	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c"; 
		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	}
	
	public Cliente getClienteEmail(String email){
		String jpql = "SELECT c FROM Cliente c WHERE c.correo = :email";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("email", email);
		List<Cliente> clientes = q.getResultList();
		if (clientes.size() > 0)
			return clientes.get(0);
		return null;
		}
	
	public Cliente getClientePorId(int codigo) {
		String jpql = "SELECT c FROM Cliente c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("codigo", codigo);
		List<Cliente> clientes = q.getResultList();
		if (clientes.size() > 0)
			return clientes.get(0);
		return null;
		}
}
