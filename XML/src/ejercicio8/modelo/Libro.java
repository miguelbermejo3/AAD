package ejercicio8.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Libro {
	private Integer isbn;
	private String titulo;
	private List<String> autores;
	private List<Edicion> ediciones;
	
	public Libro() {
		autores= new ArrayList<String>();
		ediciones= new ArrayList<Edicion>();
	}
	
	public Libro(Integer isbn, String titulo) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		autores = new ArrayList<>();
		ediciones = new ArrayList<>();
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	public List<Edicion> getEdiciones() {
		return ediciones;
	}
	public void setEdiciones(List<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
	
	
	public static List<Libro> createRandomList(Integer numLibros) {
		List<Libro> libros = new ArrayList<>();
		for (int i = 1; i <= numLibros; i++) { 
			libros.add(Libro.createRandomLibro());
		}

		return libros;
		
	}
	
	
	
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores + ", ediciones=" + ediciones + "]";
	}

	private static Libro createRandomLibro() {
		Random random = new Random();
		Integer isbn = random.nextInt(800000000)+100000000;
		Integer numEdiciones = random.nextInt(2)+1;
		Integer numAutores = random.nextInt(2)+1;
		Integer numPalabras = random.nextInt(2)+2;
		String titulo = generateRandomWords(numPalabras);
		
		Libro libro = new Libro(isbn, titulo);

		for (int i = 0; i < numAutores; i++) {
			String autor = generateRandomWords(2);
			libro.getAutores().add(autor);
		}
		
		for (int i = 0; i < numEdiciones; i++) {
			Integer año = random.nextInt(60)+1950;
			numPalabras = random.nextInt(2)+2;
			String editorial = generateRandomWords(numPalabras);
			Edicion ed = new Edicion(año, editorial);
			libro.getEdiciones().add(ed);
		}
		return libro;
	}
	
	private static String generateRandomWords(int numberOfWords){
		Random random = new Random();
	    String randomStrings = "";
	    for(int i = 0; i < numberOfWords; i++)   {
	        char[] word = new char[random.nextInt(8)+3]; 
	        for(int j = 0; j < word.length; j++)  {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings += new String(word);
	        if (i<numberOfWords-1) {
	        	randomStrings += " ";
	        }
	    }
	    return randomStrings;
	}
}
