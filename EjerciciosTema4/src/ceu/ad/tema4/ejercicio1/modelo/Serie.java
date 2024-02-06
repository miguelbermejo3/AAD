package ceu.ad.tema4.ejercicio1.modelo;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	
	@Column(name = "fecha_estreno")
	private Date estreno;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_trailer")
	private Trailer trailer;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_serie", nullable = false)
	private List<Temporada> temporadas;

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

	public Date getEstreno() {
		return estreno;
	}

	public void setEstreno(Date estreno) {
		this.estreno = estreno;
	}

	public Trailer getTrailer() {
		return trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", descripcion=" + descripcion + ", estreno=" + estreno + ", trailer=" + trailer
				+ ", temporadas=" + temporadas + "]";
	}


}
