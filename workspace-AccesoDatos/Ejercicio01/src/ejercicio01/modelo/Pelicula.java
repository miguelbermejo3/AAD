package ejercicio01.modelo;

public class Pelicula {

	private int id;
	private String nombre;
	private int longitud;

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", longitud=" + longitud + "]";
	}

}
