package modelo;

public class Direccion {

	private String domicilio;
	private String ciudad;
	private Integer cp;

	public Direccion(String domicilio,String ciudad,Integer cp) {
		this.domicilio=domicilio;
		this.ciudad=ciudad;
		this.cp=cp;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Direccion [domicilio=" + domicilio + ", ciudad=" + ciudad + ", cp=" + cp + "]";
	}

}
