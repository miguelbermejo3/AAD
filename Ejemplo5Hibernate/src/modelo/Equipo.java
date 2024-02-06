package modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equipo")
	private Long id;

	private String nombre;
	
	@OneToMany(mappedBy="equipo",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	
	private List<Jugador>jugadores;

	// esto es para onetoone
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "id_estadio", nullable = false)
	private Estadio estadio;

	@Column(name = "num_jugadores")
	private Integer numJugadores;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)//fetch para que también consulte y cascade para la hora de eliminar,insertar y update
	@JoinTable(name="socios_equipo",joinColumns={@JoinColumn(name="id_equipo")},
	inverseJoinColumns= {@JoinColumn(name="id_socio")})
	private List<Socio> socios;
	

	public Equipo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(Integer numJugadores) {
		this.numJugadores = numJugadores;
	}

	

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", jugadores=" + jugadores + ", estadio=" + estadio
				+ ", numJugadores=" + numJugadores + "]";
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}
	
	
	
	

}
