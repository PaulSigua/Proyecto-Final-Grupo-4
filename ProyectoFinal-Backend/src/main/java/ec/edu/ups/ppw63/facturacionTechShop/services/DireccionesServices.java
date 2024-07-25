package ec.edu.ups.ppw63.facturacionTechShop.services;

import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.bussines.GestionDirecciones;
import ec.edu.ups.ppw63.facturacionTechShop.dto.RespuestaIngreso;
import ec.edu.ups.ppw63.facturacionTechShop.model.Direcciones;
import ec.edu.ups.ppw63.facturacionTechShop.model.Direcciones;
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

@Path("direcciones")
public class DireccionesServices {
	
	@Inject
	private GestionDirecciones gDirecciones;


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Direcciones direcciones) {
		try{
			gDirecciones.guardarDireccioness(direcciones);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Direcciones).build();
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
	public Response actualizar(Direcciones direcciones) {
		try{
			gDirecciones.actualizarDirecciones(direcciones);
			return Response.ok(direcciones).build();
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
			gDirecciones.borrarDirecciones(codigo);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Direcciones).build();
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
	public Response getDireccioness(){
		List<Direcciones> DireccionesList = gDirecciones.getDireccioness();
		if(DireccionesList.size()>0)
			return Response.ok(DireccionesList).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Direccioness");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leerPorCliente(@QueryParam("codigo") int codigo) {
			System.out.println("id " +  codigo );
			Direcciones dir = gDirecciones.getDireccionPorCliente(codigo);
			if(dir != null) 
				return Response.ok(dir).build();
			
			ErrorMessage error = new ErrorMessage(4, "direccion no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
			
	}

}