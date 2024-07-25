package ec.edu.ups.ppw63.facturacionTechShop.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class DetalleFacturas {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "det_codigo")
	private int codigo;
	
	@Column(name = "det_cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "det_precio_total", nullable = false)
	private float precioTotal;
	
	@Column(name = "det_precio_subtotal", nullable = false)
	private float precioSubTotal;
	
	@Column(name = "det_precio_iva", nullable = false)
	private float precioIva;
	
	@ManyToOne
	@JoinColumn(name = "pro_codigo")
	Productos productos;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioSubTotal() {
		return precioSubTotal;
	}

	public void setPrecioSubTotal(float precioSubTotal) {
		this.precioSubTotal = precioSubTotal;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public float getPrecioIva() {
		return precioIva;
	}

	public void setPrecioIva(float precioIva) {
		this.precioIva = precioIva;
	}
	

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "DetalleFacturas [codigo=" + codigo + ", cantidad=" + cantidad + ", precioTotal=" + precioTotal
				+ ", precioIva=" + precioIva + ", productos=" + productos
				+ "]";
	}

	
	
	
}
