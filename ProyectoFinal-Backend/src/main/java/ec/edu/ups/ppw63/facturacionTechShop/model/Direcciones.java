package ec.edu.ups.ppw63.facturacionTechShop.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Direcciones {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "dir_codigo")
	private int codigo;
	
	@Column(name = "dir_pais", length = 60, nullable = false)
	private String nombrePais;
	
	@Column(name = "dir_provincia", length = 60, nullable = false)
	private String nombreProvincia;
	
	@Column(name = "dir_ciudad", length = 60, nullable = false)
	private String nombreCiudad;
	
	@Column(name = "dir_codigo_postal", length = 10, nullable = false)
	private String codigoPostal;
	
	@Column(name = "dir_direccion_principal", length = 120, nullable = false)
	private String direccionPricipal;
	
	@Column(name = "dir_direccion_secundaria", length = 120, nullable = false)
	private String direccionSecundaria;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccionPricipal() {
		return direccionPricipal;
	}

	public void setDireccionPricipal(String direccionPricipal) {
		this.direccionPricipal = direccionPricipal;
	}

	public String getDireccionSecundaria() {
		return direccionSecundaria;
	}

	public void setDireccionSecundaria(String direccionSecundaria) {
		this.direccionSecundaria = direccionSecundaria;
	}
	
	

	//public List<Cliente> getClienteList() {
	//	return clienteList;
	//}

	//public void setClienteList(List<Cliente> clienteList) {
	//	this.clienteList = clienteList;
	//}
	
	//public void addClienteDir (Cliente cliente) {
	//	if (clienteList == null)
		//	clienteList = new ArrayList<Cliente>();
	//		
	//	clienteList.add(cliente);
	//}
	
	

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	@Override
	public String toString() {
		return "Direcciones [codigo=" + codigo + ", nombrePais=" + nombrePais + ", nombreCiudad=" + nombreCiudad
				+ ", codigoPostal=" + codigoPostal + ", direccionPricipal=" + direccionPricipal
				+ ", direccionSecundaria=" + direccionSecundaria + "]";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
