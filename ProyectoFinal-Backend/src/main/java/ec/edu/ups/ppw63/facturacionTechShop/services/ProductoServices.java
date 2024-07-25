package ec.edu.ups.ppw63.facturacionTechShop.services;

import java.util.List;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.contrib.cdi.Traced;
import io.opentracing.util.GlobalTracer;
import ec.edu.ups.ppw63.facturacionTechShop.bussines.GestionProductos;
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

@Path("productos")
public class ProductoServices {
	
	@Inject
	private GestionProductos gProducto;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Productos producto) {
		try{
			gProducto.guardarProductos(producto);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Producto).build();
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
	public Response actualizar(Productos producto) {
		try{
			gProducto.actualizarProducto(producto);
			return Response.ok(producto).build();
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
	public Response getProductos(){
		List<Productos> productos = gProducto.getProductos();
		if(productos.size()>0)
			return Response.ok(productos).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Productos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer3(@QueryParam("codigo") int codigo) {
		try{
			System.out.println("codigo " +  codigo );
			Productos pro = gProducto.getProductoPorId(codigo);
			return Response.ok(pro).build();
			
		}catch (Exception e) {
			
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "el producto no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
			
			
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("ofertas")
	@Traced
	public Response getOfertas(){
		List<Productos> productos = gProducto.getOfertas();
		if(productos.size()>0)
			return Response.ok(productos).build();

		ErrorMessage error = new ErrorMessage(6, "No se registran Productos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
	@Traced
    public Response buscarProductos(@QueryParam("nombre") String nombre) {
        List<Productos> productos = gProducto.buscarPorNombre(nombre);
        if (productos.isEmpty()) {
        	ErrorMessage error = new ErrorMessage(404, "No se encontraron productos");
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
        return Response.ok(productos).build();
    }

}