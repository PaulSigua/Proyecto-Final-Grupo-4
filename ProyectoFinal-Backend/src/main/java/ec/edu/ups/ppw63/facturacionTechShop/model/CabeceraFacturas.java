package ec.edu.ups.ppw63.facturacionTechShop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CabeceraFacturas {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "cab_codigo")
	private int codigo;
	
	@Column(name = "cab_fecha", nullable = false)
	private Date fecha;
	
	@Column(name = "cab_precio_total", nullable = false)
	private float precioTotal;
	
	@Column(name = "cab_precio_iva", nullable = false)
	private float precioIva;
	
	@Column(name = "cab_precio_subtotal", nullable = false)
	private float precioSubtotal;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	Cliente cliente;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fac_codigo")
	List<DetalleFacturas> detallesList;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public float getPrecioSubtotal() {
		return precioSubtotal;
	}

	public void setPrecioSubtotal(float precioSubtotal) {
		this.precioSubtotal = precioSubtotal;
	}

	public List<DetalleFacturas> getDetallesList() {
		return detallesList;
	}

	public void setDetallesList(List<DetalleFacturas> detallesList) {
		this.detallesList = detallesList;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addDetalles (DetalleFacturas detalle) {
		if (detallesList == null)
			detallesList = new ArrayList<DetalleFacturas>();
			
		detallesList.add(detalle);
	}

	
	
	@Override
	public String toString() {
		return "CabeceraFacturas [codigo=" + codigo + ", fecha=" + fecha + ", precioTotal=" + precioTotal
				+ ", precioIva=" + precioIva + ", precioSubtotal=" + precioSubtotal + ", cliente=" + cliente
				+ ", detallesList=" + detallesList + "]";
	}
	
	
	
	
	
}
