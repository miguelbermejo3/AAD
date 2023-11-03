package ejercicio5.cliente;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import ejercicio5.modelo.City;

public class CityClienteRest {
	
	private String urlBase;
	private RestTemplate restTemplate;

	public CityClienteRest(String urlBase,Integer msTimeout) {
		this.urlBase=urlBase;
		HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(msTimeout);
		this.restTemplate=new RestTemplate(factory);
		
		
	}
	
	
	public City getcity(Long id) {
		
		String url=urlBase+ "/city/{id}";
		City ciudad= restTemplate.getForObject(url, City.class,id);
		return ciudad;
		
		
	}
	
	
	
	
	public City createCity(City city) {
		
		String url=urlBase+"/city";
		city=restTemplate.postForObject(url, city,City.class);
		return city;
		
	}
	
	public void updateCity(City city) {
		
		String url=urlBase+"/city";
		restTemplate.put(url,city );
		
		
	}
	
	
	
	
	
	

}
