package ec.edu.ups.ppw63.facturacionTechShop.services;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.bussines.GestionCarrito;
import ec.edu.ups.ppw63.facturacionTechShop.dto.prueba;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Detalles_Carrito;
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

@Path("carritos")
public class CarritoServices {
	
	@Inject
	private GestionCarrito gCarrito;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarDetalle(Detalles_Carrito detalleCarrito) {
		try{
			System.out.println("INGRESOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			gCarrito.agregarDetalle(detalleCarrito);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Carrito).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	/*
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Carrito carrito) {
		try{
			gCarrito.guardarCarritos(carrito);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Carrito).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}*/
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("clear")
	public Response limpiarCarrito(prueba prueba ) {
		try{
			gCarrito.limpiarDetalles(prueba.getCodigo_cliente());
			ErrorMessage error = new ErrorMessage(15, "Limpiado");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(16, "no se pudo realizar la limpieaza" + e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getCarritos(){
		List<Carrito> carritos = gCarrito.getCarritos();
		if(carritos.size()>0)
			return Response.ok(carritos).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Carritos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leerPorCliente(@QueryParam("codigo") int codigo) {
		try{
			System.out.println("id " +  codigo );
			Carrito car = gCarrito.getClientePorCliente(codigo);
			return Response.ok(car).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Carro no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}

}
