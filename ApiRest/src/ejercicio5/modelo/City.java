package ejercicio5.modelo;

public class City {
	
	private Long id;
	private String descripcion;
	private Long countryId;
	
	public City() {
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