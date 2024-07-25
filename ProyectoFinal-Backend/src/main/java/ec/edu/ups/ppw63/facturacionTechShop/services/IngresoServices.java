package ec.edu.ups.ppw63.facturacionTechShop.services;

import ec.edu.ups.ppw63.facturacionTechShop.bussines.GestionClientes;
import ec.edu.ups.ppw63.facturacionTechShop.dto.Ingreso;
import ec.edu.ups.ppw63.facturacionTechShop.dto.RespuestaIngreso;
import ec.edu.ups.ppw63.facturacionTechShop.model.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("ingreso")
public class IngresoServices {

	@Inject
	private GestionClientes gClientes;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Ingreso ingreso) {
		try {
			RespuestaIngreso respuesta = gClientes.verificacionCredenciales(ingreso);
			if (respuesta.isInicioExitoso() == true) {
				return Response.ok(respuesta).build();
			}
		} catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
		return null;
	}

}
