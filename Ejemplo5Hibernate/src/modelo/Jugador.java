package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jugadores")
public class Jugador {

	
	@Id
	private String codigo;
	private Integer dorsal;
	private String nombre;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_equipo",nullable=false)
	private Equipo equipo;
	

	public Jugador() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getDorsal() {
		return dorsal;
	}

	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Jugadores [codigo=" + codigo + ", dorsal=" + dorsal + ", nombre=" + nombre + "]";
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	

}
