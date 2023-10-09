package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Actores.Actor;

public class ActoresPersistencia {

	public List<Actor> consultarActores(Connection conn) throws SQLException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Actor a = null;
		List<Actor> actores = new ArrayList<>();

		try {

			stmt = conn.prepareStatement("SELECT first_name FROM actor");

			rs = stmt.executeQuery();

			while (rs.next()) {

				a = new Actor();
				a.setNombre(rs.getString("first_name"));

				actores.add(a);
			}

		}

		finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}

		}

		return actores;

	}

}
