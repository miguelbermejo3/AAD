package ejercicio6.modelo;

public class Ciudad {
	private Long id;
	private String descripcion;
	private Long countryId;
	
	public Ciudad() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", descripcion=" + descripcion + ", countryId=" + countryId + "]";
	}


}
