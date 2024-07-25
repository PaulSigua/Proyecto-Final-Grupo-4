package ec.edu.ups.ppw63.facturacionTechShop.dto;

public class Ingreso {

	private String email;
	private String clave;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Ingreso [email=" + email + ", clave=" + clave + "]";
	}
	
	
}
