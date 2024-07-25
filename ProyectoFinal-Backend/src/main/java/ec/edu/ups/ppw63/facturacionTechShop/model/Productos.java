package ec.edu.ups.ppw63.facturacionTechShop.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "pro_codigo")
	private int codigo;

	@Column(name = "pro_nombre", length = 60, nullable = false)
	private String nombre;

	@Column(name = "pro_descripcion", length = 120, nullable = false)
	private String descripcion;

	@Column(name = "pro_breve_descripcion", length = 60, nullable = false)
	private String breveDescripcion;

	@Column(name = "pro_precio", nullable = false)
	private float precio;

	@Column(name = "pro_cantidad", nullable = false)
	private int cantidad;

	@Column(name = "pro_img", length = 500, nullable = true)
	private String imagen;

	@Column(name = "pro_oferta", nullable = true)
	private int oferta;
	
	@Column(name = "pro_calificacion", nullable = true)
	private int calificacion;

	public Productos(int codigo, String nombre, String descripcion, String breveDescripcion, float precio, int cantidad,
			String imagen, int oferta, int calificacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.breveDescripcion = breveDescripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.imagen = imagen;
		this.oferta = oferta;
		this.calificacion = calificacion;
	}
	
	public Productos() {}

	public int getOferta() {
		return oferta;
	}

	public void setOferta(int oferta) {
		this.oferta = oferta;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getBreveDescripcion() {
		return breveDescripcion;
	}

	public void setBreveDescripcion(String breveDescripcion) {
		this.breveDescripcion = breveDescripcion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", breveDescripcion=" + breveDescripcion + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", imagen=" + imagen + ", oferta=" + oferta + ", calificacion=" + calificacion + "]";
	}

}
