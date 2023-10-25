package ejercicio5;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ejercicio4.ApiTest;
import ejercicio5.modelo.City;
import ejercicio5.service.CityService;
import ejercicio5.service.NotFoundException;
@SpringBootApplication
@EnableAutoConfiguration
public class CityApiRest implements CityService{

	
		public static void main(String[] args) {
			SpringApplication.run(ApiTest.class, args);
		}
	

	@Override
	public List<City> getCities(String filtroDescripcion) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City getCity(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City createCity(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCity(City city) throws NotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public City updateSelectiveCity(City city) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCity(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		
	}
}
