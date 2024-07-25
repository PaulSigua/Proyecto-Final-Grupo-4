package ec.edu.ups.ppw63.facturacionTechShop.services;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.bussines.GestionCarrito;
import ec.edu.ups.ppw63.facturacionTechShop.bussines.GestionFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.dto.prueba;
import ec.edu.ups.ppw63.facturacionTechShop.model.CabeceraFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
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

@Path("facturas")
public class FacturarServices {
	
	@Inject
	private GestionFacturas gFacturas;

	@Inject
	private GestionCarrito gCarrito;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(prueba prueba) {
		try{
			Carrito carrito = gCarrito.getClientePorCliente(prueba.getCodigo_cliente());
			gFacturas.guardarFacturas(carrito);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Factura).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(CabeceraFacturas factura) {
		try{
			gFacturas.actualizarFactura(factura);
			return Response.ok(factura).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try{
			gFacturas.borrarFactura(codigo);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Factura).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getFacturas(){
		List<CabeceraFacturas> factura = gFacturas.getFacturas();
		if(factura.size()>0)
			return Response.ok(factura).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Facturas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leerPorCliente(@QueryParam("codigo") int codigo) {
		try{
			System.out.println("id " +  codigo );
			CabeceraFacturas fac = gFacturas.getFacturaPorCliente(codigo);
			return Response.ok(fac).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Carro no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}

}
