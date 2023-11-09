package ejercicio6.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ejercicio6.modelo.Ciudad;

public class CiudadesClientImpl implements CiudadesClient {

	private String urlBase;
	private RestTemplate restTemplate;

	public CiudadesClientImpl(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(factory);
	}

	@Override
	public List<Ciudad> getCities(String filtroDescripcion) throws CiudadNoEncontradaException, CiudadErrorException {

		try {
			String url = urlBase + "/city?filtroDescripcion=" + filtroDescripcion;
			Ciudad[] ciudades = restTemplate.getForObject(url, Ciudad[].class);
			return Arrays.asList(ciudades);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("no existe ciudad con el filtro" + filtroDescripcion);
			}
			throw e;
		}

	}

	@Override
	public Ciudad getCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {

		try {
			String url = urlBase + "/city/{id}";
			Ciudad ciudad = restTemplate.getForObject(url, Ciudad.class, id);
			return ciudad;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("no existe ciudad con el id= " + id);
			}
			throw e;
		}
	}

	@Override
	public Ciudad createCity(Ciudad city) throws CiudadErrorException {

		String url = urlBase + "/city";
		city = restTemplate.postForObject(url, city, Ciudad.class);
		return city;

	}

	@Override
	public void updateCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city";
			restTemplate.put(url, city);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("no existe ciudad : " + city);
			}
			throw e;
		}
	}

	@Override
	public Ciudad updateSelectiveCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city";
			city = restTemplate.patchForObject(url, city, Ciudad.class);

			return city;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("no existe la  ciudad : " + city);
			}
			throw e;
		}
	}

	@Override
	public void deleteCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city/{id}";
			restTemplate.delete(url, id);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("no existe la ciudad con el id" + id);
			}
			throw e;
		}
	}

}
