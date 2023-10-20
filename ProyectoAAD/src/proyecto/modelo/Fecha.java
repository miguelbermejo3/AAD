package proyecto.modelo;

import java.time.LocalDate;

public class Fecha {

	private LocalDate fecha;
	private int anho;
	private int evaluacion;
	private Boolean disponibilidad;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getAño() {
		return anho;
	}

	public void setAño(int anho) {
		this.anho = anho;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Fecha [fecha=" + fecha + ", año=" + anho + ", evaluacion=" + evaluacion + ", disponibilidad="
				+ disponibilidad + "]";
	}

}
