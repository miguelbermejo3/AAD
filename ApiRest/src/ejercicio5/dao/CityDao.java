package ejercicio5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio5.modelo.City;
import ejercicio5.service.NotFoundException;
import ejercicio5.service.ServerErrorException;

public class CityDao {

	public List<City> getCities(Connection conn, String filtroDescripcion)
			throws NotFoundException, SQLException, ServerErrorException {

		Statement stmt = null;
		ResultSet rs = null;
		City ciudad = null;
		List<City> ciudades = new ArrayList<>();

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from city where city like '%" + filtroDescripcion + "%'");

			while (rs.next()) {

				ciudad = new City();
				ciudad.setId(rs.getLong("city_id"));
				ciudad.setDescripcion(rs.getString("city"));
				ciudad.setCountryId(rs.getLong("country_id"));

				ciudades.add(ciudad);
			}
			

		}

		finally {

			try {
				stmt.close();
			} catch (Exception ignore) {
			}

		}

		return ciudades;

	}

	public City getCity(Connection conn, Long id) throws NotFoundException, SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		City ciudad = null;

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from city where city_id=" + id);

			if (rs.next()) {

				ciudad = new City();
				ciudad.setId(id);
				ciudad.setCountryId(rs.getLong("country_id"));
				ciudad.setDescripcion(rs.getString("city"));
				

			}else {
				return null;
			}

		}

		finally {

			try {
				stmt.close();
			} catch (Exception ignore) {
			}

		}

		return ciudad;

	}

	public City createCity(Connection conn, City city) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "insert into city ( city, country_id) values (?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getDescripcion());
			stmt.setLong(2, city.getCountryId());
			stmt.execute();
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}
		return city;
	}

	public void updateCity(Connection conn, City city) throws NotFoundException, SQLException {

		Statement st = null;

		try {
			st = conn.createStatement();
			String sql = "UPDATE city SET  city= '" + city.getDescripcion() + "' AND country_id = '"
					+ city.getCountryId() + " where city_id='" + city.getId();
			st.executeUpdate(sql);

		} finally {

			try {
				st.close();
			} catch (Exception ignore) {
			}

		}

	}

	public City updateSelectiveCity(Connection conn, City city)
			throws NotFoundException, ServerErrorException, SQLException {

		Statement st = null;
		try {

			st = conn.createStatement();
			if (city.getDescripcion() != null) {
				String sql = "UPDATE city SET  city= '" + city.getDescripcion() + "where city_id='" + city.getId();
				st.executeUpdate(sql);
			}
			if (city.getCountryId() != null) {
				String sql = "UPDATE city SET  country_id= '" + city.getCountryId() + "where city_id='" + city.getId();
				st.executeUpdate(sql);
			}

		} finally {
			try {
				st.close();
			} catch (Exception ignore) {
			}
		}

		return city;
	}

	public void deleteCity(Connection conn, Long id) throws NotFoundException, ServerErrorException, SQLException {

		Statement stmt = null;

		try {
			String sql = "DELETE FROM city WHERE city_id= " + id;
			stmt = conn.createStatement();
			stmt.execute(sql);

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}

	}

}
