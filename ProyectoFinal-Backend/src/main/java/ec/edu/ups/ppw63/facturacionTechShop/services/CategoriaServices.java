package ec.edu.ups.ppw63.facturacionTechShop.services;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.bussines.GestionCategorias;
import ec.edu.ups.ppw63.facturacionTechShop.bussines.GestionProductos;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Categorias;
import ec.edu.ups.ppw63.facturacionTechShop.model.Productos;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("categorias")
public class CategoriaServices {
	
	@Inject
	private GestionCategorias gCategorias;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getCategorias(){
		List<Categorias> categorias = gCategorias.getCategorias();
		if(categorias.size()>0)
			return Response.ok(categorias).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Productos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leerCategoriaPorId(@QueryParam("codigo") int codigo) {
		try{
			System.out.println("id " +  codigo );
			Categorias cat = gCategorias.getCategoriaPorId(codigo);
			return Response.ok(cat).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Carro no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}

}
