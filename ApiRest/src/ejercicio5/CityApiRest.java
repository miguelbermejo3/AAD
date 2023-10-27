package ejercicio5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicio4.ApiTest;
import ejercicio5.dao.CityDao;
import ejercicio5.modelo.City;
import ejercicio5.service.CityService;
import ejercicio5.service.NotFoundException;
import ejercicio5.service.OpenConnection;
import ejercicio5.service.ServerErrorException;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class CityApiRest implements CityService {

	public static void main(String[] args) {
		SpringApplication.run(ApiTest.class, args);
	}

	@Override
	@GetMapping("/city")
	public List<City> getCities(@RequestParam(required=false) String filtroDescripcion) throws NotFoundException, ServerErrorException  {
		CityDao cd = new CityDao();
		List<City> ciudades = new ArrayList<>();
		Connection conn = null;

		try {
			conn = new OpenConnection().getNewConnection();
			ciudades = cd.getCities(conn, filtroDescripcion);
			
			if(ciudades==null) {
				throw new NotFoundException("No existe  Ciudad con el filtro indicado");
			}
			return ciudades;
		} catch (SQLException e) {
			throw new ServerErrorException("Error en el servidor",e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

		
		
	}

	@Override
	@GetMapping("/city/{id}")
	public City getCity(@PathVariable Long id) throws NotFoundException, ServerErrorException {
		CityDao cd = new CityDao();
		Connection conn = null;
		City city = new City();

		try {
			conn = new OpenConnection().getNewConnection();
			city = cd.getCity(conn, id);
			if(city.getId()!=id) {
				throw new NotFoundException("No existe  Ciudad con el ID indicado");
			}

		} catch (SQLException e) {
			throw new ServerErrorException("Error en el servidor",e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

		return city;
	}

	@Override
	@PostMapping("/city")
	public City createCity( @RequestBody  City city) {
		Connection conn = null;

		CityDao cd = new CityDao();

		try {
			conn = new OpenConnection().getNewConnection();
			cd.createCity(conn, city);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

		return city;
	}

	@Override
	@PutMapping("/city")
	public void updateCity(@RequestBody   City city) throws NotFoundException, ServerErrorException {
		CityDao cd = new CityDao();
		Connection conn = null;

		try {
			conn = new OpenConnection().getNewConnection();
			cd.updateCity(null, city);

		} catch (SQLException e) {
			throw new ServerErrorException("Error en el servidor",e);
			
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

	}

	@Override
	@PatchMapping("/city")
	public City updateSelectiveCity( @RequestBody  City city) throws NotFoundException, ServerErrorException {
		CityDao cd = new CityDao();
		Connection conn = null;
		try {
			conn = new OpenConnection().getNewConnection();
			cd.updateSelectiveCity(conn, city);

		} catch (SQLException e) {
			throw new ServerErrorException("Error en el servidor",e);

		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

		return city;
	}

	@Override
	@DeleteMapping("/city")
	public void deleteCity(@RequestParam  Long id) throws NotFoundException, ServerErrorException {

		CityDao cd = new CityDao();
		Connection conn = null;
		try {
			conn = new OpenConnection().getNewConnection();
			cd.deleteCity(conn, id);

		} catch (SQLException e) {
			throw new ServerErrorException("Error en el servidor",e);

		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

	}
}
