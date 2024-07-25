package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ec.edu.ups.ppw63.facturacionTechShop.dao.FacturaDAO;
import ec.edu.ups.ppw63.facturacionTechShop.dao.ProductosDao;
import ec.edu.ups.ppw63.facturacionTechShop.model.CabeceraFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.DetalleFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Productos;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionFacturas {

	@Inject
	private FacturaDAO daoFactura;
	
	@Inject
	private ProductosDao daoProducto;
	
	public void actualizarFactura(CabeceraFacturas factura) throws Exception {
		CabeceraFacturas cli = daoFactura.read(factura.getCodigo());
		if (cli != null){
			daoFactura.update(factura);
		}else {
			throw new Exception("Factura no existe");
		}
	}
	
	public void guardarFacturas(Carrito carrito) {
		CabeceraFacturas fac = new CabeceraFacturas();
		fac.setCliente(carrito.getCliente());
		fac.setFecha(new Date());
		System.out.println("La fecha es: " + fac.getFecha() + " El string de la fecha es: " + fac.getFecha().toString() + "fsdf" + new Date());
		for(int i = 0; i < carrito.getDetalles().size(); i++) {
			System.out.println("Entro a meter detalles");
			DetalleFacturas det  = new DetalleFacturas();
			det.setCantidad(carrito.getDetalles().get(i).getCantidad());
			Productos pro = daoProducto.read(carrito.getDetalles().get(i).getCodigoProducto());
			det.setProductos(pro);
			det.setPrecioSubTotal((float) (pro.getPrecio() * carrito.getDetalles().get(i).getCantidad()));
			det.setPrecioIva((det.getPrecioSubTotal() * (12)) / 100);		
			det.setPrecioTotal(det.getPrecioIva() + det.getPrecioSubTotal());
			
			fac.setPrecioSubtotal(fac.getPrecioSubtotal()+det.getPrecioSubTotal());
			fac.setPrecioIva(fac.getPrecioIva()+det.getPrecioIva());
			fac.setPrecioTotal(fac.getPrecioTotal()+det.getPrecioTotal());
			
			fac.addDetalles(det);
		}
		
		daoFactura.insert(fac);
	}
	
	public void borrarFactura(int codigo) {
		daoFactura.remove(codigo);
	}
	
	public List<CabeceraFacturas> getFacturas(){
		return daoFactura.getAll();
	}
	
	public CabeceraFacturas getFacturaPorCliente(int codigo){
		return daoFactura.getFacturaPorCliente(codigo);
	}

	
}
