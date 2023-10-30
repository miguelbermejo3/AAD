package ejercicio5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio5.modelo.City;

public class CityDao {

	public List<City> getCities(Connection conn, String filtroDescripcion)
			throws  SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		List<City> ciudades = new ArrayList<>();

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from city where city like '%" + filtroDescripcion + "%'");

			while (rs.next()) {

				City ciudad = new City();
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

	public City getCity(Connection conn, Long id) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		City ciudad = null;

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from city where city_id=" + id);

			if (rs.next()) {

				ciudad = new City();
				ciudad.setId(id);
				ciudad.setDescripcion(rs.getString("city"));
				ciudad.setCountryId(rs.getLong("country_id"));

			} else {
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

	public Long createCity(Connection conn, City city) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "insert into city ( city, country_id) values (?,?)";
			stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, city.getDescripcion());
			stmt.setLong(2, city.getCountryId());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}
		
	}

	public Integer updateCity(Connection conn, City city) throws  SQLException {

		Statement st = null;

		try {
			st = conn.createStatement();
			String sql = "UPDATE city SET  city= '" + city.getDescripcion() + "' , country_id = "
					+ city.getCountryId() + " where city_id=" + city.getId();
			
			return st.executeUpdate(sql);

		} finally {

			try {
				st.close();
			} catch (Exception ignore) {
			}

		}
		

	}

	public Integer updateSelectiveCity(Connection conn, City city)
			throws  SQLException {
		String sql=null;
		Statement st = null;
		try {

			st = conn.createStatement();
			if (city.getDescripcion() != null) {
				 sql = "UPDATE city SET  city= '" + city.getDescripcion() + "'where city_id=" + city.getId();
			
			}
			else if  (city.getCountryId() != null) {
				 sql = "UPDATE city SET  country_id= " + city.getCountryId() + "where city_id=" + city.getId();
				
			}
			else if (city.getCountryId()!=null &&city.getDescripcion()!=null) {
				updateCity(conn,city);
			}
			return 	st.executeUpdate(sql);

		} finally {
			try {
				st.close();
			} catch (Exception ignore) {
			}
		}
		

		
	}

	public void deleteCity(Connection conn, Long id) throws SQLException {

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
