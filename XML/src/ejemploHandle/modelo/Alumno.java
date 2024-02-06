package ejemploHandle.modelo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;



public class Alumno {

	@JacksonXmlProperty(isAttribute=true)//para indicar que el dni es un atributo de alumno
	private String dni;
	@JacksonXmlText //para que el nombre vaya dentro del tag alumno
	private String nombre;
	
	public Alumno(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public Alumno() {
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + "]";
	}


}
