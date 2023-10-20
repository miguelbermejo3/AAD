package ejercicio01.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import ejercicio01.dao.PeliculaDao;
import ejercicio01.modelo.Pelicula;

public class PeliculaService {

	private OpenConnection openConn;

	public PeliculaService() {
		openConn = new OpenConnection();
	}

	public List<Pelicula> consultarPeliculas(int longitud) throws PeliculasServiceException {

		Connection conn = null;

		try {
			conn = openConn.getNewConnection();
			PeliculaDao dao = new PeliculaDao();

			List<Pelicula> peliculas = dao.consultarPeliculas(conn);

			Iterator<Pelicula> iterador = peliculas.iterator();
			while (iterador.hasNext()) {
				Pelicula peli = iterador.next();
				if (peli.getLongitud() > longitud) {
					
					iterador.remove();
				}

			}
			return peliculas;
			
		}

		catch (SQLException e) {

			System.out.println("ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new PeliculasServiceException("Error al obtener datos de la bbd", e);

		}

		finally {

			try {
				conn.close();
			} catch (Exception e) {
			}

		}
	}

}
