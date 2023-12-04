package proyecto.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import proyecto.modelo.Fecha;
import proyecto.modelo.Registro;
import proyecto.modelo.Usuario;
import proyecto.service.autenticarUsuarioException;
import proyecto.service.fctException;

public class ProyectoClient {

	private String urlBase;
	private RestTemplate restTemplate;

	public ProyectoClient(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(factory);
	}

	public List<Fecha> consultarFechasActuales() throws fctException {

		try {

			String url = urlBase + "/fecha";

			Fecha[] fechas = restTemplate.getForObject(url, Fecha[].class);
			return Arrays.asList(fechas);

		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new fctException("error en la bbd", e);
			}
			throw e;
		}
	}

	public List<Registro> consultarRegistro(long idUsuario) throws fctException {

		try {

			String url = urlBase + "/registro/usuario/{idUsuario}";
			Registro[] registro = restTemplate.getForObject(url, Registro[].class, idUsuario);
			return Arrays.asList(registro);

		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new fctException("no se encuentra registro");
			}
			throw e;

		}

	}

	public void crearRegistro(Registro registro) throws fctException {

		try {
			String url = urlBase + "/registro";
			registro = restTemplate.postForObject(url, registro, Registro.class);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new fctException("ya existe el registro");
			}
			throw e;
		}

	}

	

}
