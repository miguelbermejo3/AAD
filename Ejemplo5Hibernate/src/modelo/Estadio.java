package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Estadio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estadio")
	private Long idEstadio;

	private String nombre;
	private String direccion;

	@OneToOne(mappedBy = "estadio", cascade = CascadeType.ALL)
	private Equipo equipo;

	public Estadio() {

	}

	public Long getIdEstadio() {
		return idEstadio;
	}

	public void setIdEstadio(Long idEstadio) {
		this.idEstadio = idEstadio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Estadio [idEstadio=" + idEstadio + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	

}
