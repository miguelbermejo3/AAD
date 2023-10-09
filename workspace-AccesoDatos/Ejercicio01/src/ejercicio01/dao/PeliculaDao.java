package ejercicio01.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio01.modelo.Pelicula;

public class PeliculaDao {

	public List<Pelicula> consultarPeliculas(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		Pelicula a = null;
		List<Pelicula> peliculas = new ArrayList<>();

		try {
			
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from film");

			while (rs.next()) {

				a = new Pelicula();
				a.setId(rs.getInt("film_id"));
				a.setNombre(rs.getString("title"));
				a.setLongitud(rs.getInt("length"));
				peliculas.add(a);
			}

		}

		finally {

			try {
				stmt.close();
			} catch (Exception e) {
			}

		}

		return peliculas;

	}

}
