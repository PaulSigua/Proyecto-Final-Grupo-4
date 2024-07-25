package ec.edu.ups.ppw63.facturacionTechShop.bussines;

import java.util.Date;
import java.util.List;


import ec.edu.ups.ppw63.facturacionTechShop.dao.CabecerasDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.CarritoDAO;
import ec.edu.ups.ppw63.facturacionTechShop.dao.CategoriaDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.ClienteDao;
import ec.edu.ups.ppw63.facturacionTechShop.dao.ProductosDao;
import ec.edu.ups.ppw63.facturacionTechShop.model.CabeceraFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Categorias;
import ec.edu.ups.ppw63.facturacionTechShop.model.Cliente;
import ec.edu.ups.ppw63.facturacionTechShop.model.DetalleFacturas;
import ec.edu.ups.ppw63.facturacionTechShop.model.Detalles_Carrito;
import ec.edu.ups.ppw63.facturacionTechShop.model.Direcciones;
import ec.edu.ups.ppw63.facturacionTechShop.model.Productos;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private ClienteDao daoCliente;
	
	@Inject
	private CategoriaDao daoCategoria;
	
	@Inject
	private ProductosDao daoProducto;
	
	@Inject
	private CabecerasDao daoFactura;
	
	@Inject
	private CarritoDAO daoCarrito;
	
	@PostConstruct
	public void init() {
System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setPrimerNombre("Daniel");
		cliente.setPrimerApellido("Collaguazo");
		cliente.setCorreo("collaguazodaniel48@gmail.com");
		cliente.setContrasenia("123");
		
		daoCliente.insert(cliente);
		
		Cliente cliente2 = new Cliente();
		cliente2.setPrimerNombre("Claudio");
		cliente2.setPrimerApellido("Collaguazo");
		cliente2.setCorreo("claudiocf26@gmail.com");
		cliente2.setContrasenia("123");
		
		daoCliente.insert(cliente2);
		
		Direcciones direcciones = new Direcciones();
		direcciones.setNombrePais("Ecuador");
		direcciones.setNombreCiudad("Cuenca");
		direcciones.setCodigoPostal("010101");
		direcciones.setDireccionPricipal("Racar");
		direcciones.setDireccionSecundaria("Camino sin nombre");
		
///////////////////////////////////////////////////////////////////////////////////////////////
		Productos producto = new Productos();
		producto.setNombre("PITON HEMBRA CALEFON 1/2″ GAS");
		producto.setDescripcion("Acople para manguera de 1/2×5/16″, medida generalmente utilizada para manguera de calefón  a gas.");
		producto.setBreveDescripcion("Rosca: NPT");
		producto.setPrecio(3);
		producto.setCantidad(50);
		producto.setImagen("/assets/img/productos/piton-acople-CALEFON.jpg");
		producto.setOferta(20);
		daoProducto.insert(producto);
		
		Productos producto2 = new Productos();
		producto2.setNombre("PITON HEMBRA SECADORA 3/8″ GAS");
		producto2.setDescripcion("Acople para manguera de 3/8×5/16″, medida generalmente utilizada para manguera de secadora a gas.");
		producto2.setBreveDescripcion("Acero Carbono");
		producto2.setPrecio(6);
		producto2.setCantidad(20);
		producto2.setImagen("/assets/img/productos/adaptador-piton-acople-secadora.jpg");
		daoProducto.insert(producto2);
		
		Productos producto3 = new Productos();
		producto3.setNombre("Adaptador Tipo T 6606");
		producto3.setDescripcion("Para trabajos de líneas hidráulicas");
		producto3.setBreveDescripcion("Mesa de comedor fammiliar para 6 personas");
		producto3.setPrecio(5);
		producto3.setCantidad(30);
		producto3.setImagen("/assets/img/productos/adap-6606-T.jpg");
		producto3.setOferta(10);
		daoProducto.insert(producto3);
		
		Productos productoo = new Productos();
		productoo.setNombre("Adaptador Flex 16 X 1/2 Macho");
		productoo.setDescripcion("Accesorios para equipos de riego");
		productoo.setBreveDescripcion("Ideal para manguera en milimetros");
		productoo.setPrecio(1);
		productoo.setCantidad(21);
		productoo.setImagen("/assets/img/productos/flex.jpeg");
		productoo.setOferta(10);
		daoProducto.insert(productoo);
		
		
		Categorias categoria = new Categorias();
		categoria.setNombre("Adaptadores");
		categoria.setImagen("/assets/img/categorias/adaptador.png");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		categoria.getProductosList().add(producto3);
		categoria.getProductosList().add(productoo);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////
		
		Productos producto4 = new Productos();
		producto4.setNombre("Llaves Boca Corona");
		producto4.setDescripcion("Llaves Boca Corona Metricas 14 Pzas (7Mm-22Mm)");
		producto4.setBreveDescripcion("Numero de piezas: 14 piezas");
		producto4.setPrecio(60);
		producto4.setCantidad(9);
		producto4.setImagen("/assets/img/productos/stanley.jpg");
		producto4.setOferta(20);
		daoProducto.insert(producto4);
		
		Productos producto5 = new Productos();
		producto5.setNombre("Llave de Tubo");
		producto5.setDescripcion("Fabricado en acero, cromo molibdeno, mango de hierro fundido nodular");
		producto5.setBreveDescripcion("Ideal para grifería");
		producto5.setPrecio(20);
		producto5.setCantidad(17);
		producto5.setImagen("/assets/img/productos/llavetubo.png");
		producto5.setOferta(10);
		daoProducto.insert(producto2);
		
		Productos producto6 = new Productos();
		producto6.setNombre("Llave de Pico con Aislante Completo");
		producto6.setDescripcion("Llave multifuncional de agarre suave construida en aleación de acero forjado");
		producto6.setBreveDescripcion("Cómodo mango de vinil acojinado");
		producto6.setPrecio(18);
		producto6.setCantidad(20);
		producto6.setImagen("/assets/img/productos/pico.png");
		daoProducto.insert(producto3);
		
		
		Categorias categoria2 = new Categorias();
		categoria2.setNombre("Llaves");
		categoria2.setImagen("/assets/img/categorias/llave.jpg");
		categoria2.getProductosList().add(producto4);
		categoria2.getProductosList().add(producto5);
		categoria2.getProductosList().add(producto6);
		daoCategoria.insert(categoria2);
		
///////////////////////////////////////////////////////////////////////////////////////////////

		
		producto = new Productos();
		producto.setNombre("Taladro Inalámbrico 13 MM / 1500 RPM");
		producto.setDescripcion("Voltaje: 24 V DC\r\n"
				+ "Velocidad: 0-750 / 0-1500 RPM\r\n"
				+ "Modos: Fijación / Perforación\r\n"
				+ "Choque: 13 mm\r\n");
		producto.setBreveDescripcion("Estructura reforzada para una mayor vida útil.");
		producto.setPrecio(70);
		producto.setCantidad(10);
		producto.setImagen("/assets/img/productos/taladrouno.png");
		daoProducto.insert(producto);
		
		producto2 = new Productos();
		producto2.setNombre("Taladro 900 W / 13 MM / 3000 RPM");
		producto2.setDescripcion("Voltaje: 110 V\r\n"
				+ "Velocidad: 0 – 3000 RPM\r\n"
				+ "Potencia: 900 W");
		producto2.setBreveDescripcion("Sistema percutor para perforar materiales duros.");
		producto2.setPrecio(30);
		producto2.setCantidad(8);
		producto2.setImagen("/assets/img/productos/taladrodos.png");
		daoProducto.insert(producto2);
		
		producto3 = new Productos();
		producto3.setNombre("Choque para Taladros");
		producto3.setDescripcion("Adaptador choque para taladros");
		producto3.setBreveDescripcion("Adaptador choque para taladros");
		producto3.setPrecio(11);
		producto3.setCantidad(15);
		producto3.setImagen("/assets/img/productos/taladrochoque.png");
		daoProducto.insert(producto3);
		
		
		categoria = new Categorias();
		categoria.setNombre("Eléctricas");
		categoria.setImagen("/assets/img/categorias/electricas.jpg");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		categoria.getProductosList().add(producto3);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////

		
		producto = new Productos();
		producto.setNombre("CEMENTO GRIS 50 KG ATENAS ATENAS");
		producto.setDescripcion("CEMENTO GRIS 50 KG ATENAS ATENAS");
		producto.setBreveDescripcion("CEMENTO GRIS 50 KG ATENAS ATENAS");
		producto.setPrecio(8);
		producto.setCantidad(200);
		producto.setImagen("/assets/img/productos/cemento.jpg");
		producto.setOferta(25);
		daoProducto.insert(producto);
		
		producto2 = new Productos();
		producto2.setNombre("Pala de Acero Puntona con Mango Plástico");
		producto2.setDescripcion("Pintado con epoxi.\r\n"
				+ "Fabricado con acero al carbono templado.");
		producto2.setBreveDescripcion("Cuerpo de madera.\r\n"
				+ "Ideal para cavar, remover y recoger.\r\n");
		producto2.setPrecio(8);
		producto2.setCantidad(25);
		producto2.setImagen("/assets/img/productos/pala.png");
		producto2.setOferta(35);
		daoProducto.insert(producto2);
		
		categoria = new Categorias();
		categoria.setNombre("Construcción");
		categoria.setImagen("/assets/img/categorias/construccion.jpg");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////

		
		producto = new Productos();
		producto.setNombre("Bota Amarilla de Caucho con Forro");
		producto.setDescripcion("Elaboradas en PVC de alta resistencia.");
		producto.setBreveDescripcion("Suela resistente, posee un labrado profundo.");
		producto.setPrecio(15);
		producto.setCantidad(30);
		producto.setImagen("/assets/img/productos/botauno.png");
		producto.setOferta(15);
		daoProducto.insert(producto);
		
		producto2 = new Productos();
		producto2.setNombre("Bota de Caucho Negra con Forro");
		producto2.setDescripcion("Suela resistente, posee un labrado profundo");
		producto2.setBreveDescripcion("Ideal para trabajo pesado");
		producto2.setPrecio(15);
		producto2.setCantidad(35);
		producto2.setImagen("/assets/img/productos/botados.png");
		daoProducto.insert(producto2);
		
		categoria = new Categorias();
		categoria.setNombre("Agricola");
		categoria.setImagen("/assets/img/categorias/agricola.jpg");
		categoria.getProductosList().add(producto);
		categoria.getProductosList().add(producto2);
		daoCategoria.insert(categoria);
		
///////////////////////////////////////////////////////////////////////////////////////////////
		
		DetalleFacturas det = new DetalleFacturas();
		det.setCantidad(2);
		det.setPrecioTotal(25);
		det.setPrecioIva(5);
		det.setProductos(producto);
		
		CabeceraFacturas factura = new CabeceraFacturas();
		factura.setCliente(cliente);
		factura.setFecha(new Date());
		factura.setPrecioTotal(100);
		factura.setPrecioIva(20);
		factura.setPrecioSubtotal(80);
		
		factura.addDetalles(det);
		
		DetalleFacturas det2 = new DetalleFacturas();
		det2.setCantidad(3);
		det2.setPrecioTotal(30);
		det2.setPrecioIva(6);
		det2.setProductos(producto2);
		
		factura.addDetalles(det2);
	
		DetalleFacturas det3 = new DetalleFacturas();
		det3.setCantidad(4);
		det3.setPrecioTotal(40);
		det3.setPrecioIva(7);
		det3.setProductos(producto3);
		
		factura.addDetalles(det3);
		
		
		daoFactura.insert(factura);
		
		
		factura = new CabeceraFacturas();
		factura.setCliente(cliente);
		factura.setFecha(new Date());
		factura.setPrecioTotal(100);
		factura.setPrecioIva(20);
		factura.setPrecioSubtotal(80);
		
		
		DetalleFacturas det4 = new DetalleFacturas();
		det2.setCantidad(3);
		det2.setPrecioTotal(30);
		det2.setPrecioIva(6);
		det2.setProductos(producto2);

		factura.addDetalles(det4);
	
		DetalleFacturas det5 = new DetalleFacturas();
		det3.setCantidad(4);
		det3.setPrecioTotal(40);
		det3.setPrecioIva(7);
		det3.setProductos(producto3);
		
		factura.addDetalles(det5);
		
		
		daoFactura.insert(factura);
		
		/*Carrrrito*/
		Carrito car1 = new Carrito();
		car1.setCliente(cliente);
		
		Detalles_Carrito dcar1 = new Detalles_Carrito();
		dcar1.setCantidad(2);
		dcar1.setCodigoProducto(1);
		
		Detalles_Carrito dcar2 = new Detalles_Carrito();
		dcar2.setCantidad(2);
		dcar2.setCodigoProducto(2);
		
		car1.addDetalles(dcar1);
		car1.addDetalles(dcar2);
		
		daoCarrito.insert(car1);
		
		Carrito car2 = new Carrito();
		car2.setCliente(cliente2);
		
		
		Detalles_Carrito dcar3 = new Detalles_Carrito();
		dcar3.setCantidad(2);
		dcar3.setCodigoProducto(3);
		
		Detalles_Carrito dcar4 = new Detalles_Carrito();
		dcar4.setCantidad(2);
		dcar4.setCodigoProducto(4);
		
		car2.addDetalles(dcar3);
		car2.addDetalles(dcar4);
		
		daoCarrito.insert(car2);
		
		
		
		
		/*System.out.println("\n------------- Clientes");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n--------------------------------------------------- Facturas2");
		List<CabeceraFacturas> list2 = daoFactura.getAll();
		List<Categorias> list3 = daoCategoria.getAll();
//		List<Productos> list4 = daoProducto.getOfertas();
		
		daoProducto.getOfertas();
		for (Categorias fac: list3) {
			System.out.println("wazaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+fac.toString());
		}
//		for(Productos x: list4 ) {
//			System.out.println("sfajjsdkfjaskdjfsadjflksjdflkasjdlfkjsldf" + x.toString());
//		}
	}
}
