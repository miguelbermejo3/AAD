package ejercicio6.client;

import java.util.List;

import ejercicio6.modelo.Ciudad;

public interface CiudadesClient {

	/** Devuelve la lista de ciudades que devuelva el servicio REST filtrando 
	 * por la descripción indicada. Si el servicio devuelve un 404 
	 * lanzaremos la excepción NotFoundException 
	 * @param filtroDescripcion - El parámetro se pasará con este nombre 
	 * @return
	 */
	public List<Ciudad> getCities(String filtroDescripcion) throws CiudadNoEncontradaException, CiudadErrorException;
	
	
	
	
	
	/** Devuelve la ciudad con el id indicado que devuelva el servicio  
	 * Si el servicio devuelve un 404, lanzaremos la excepción NotFoundException 
	 * @param id 
	 * @return
	 */
	public Ciudad getCity(Long id)  throws CiudadNoEncontradaException, CiudadErrorException;
	
	
	
	
	
	/** Invoca al servicio para crear la ciudad que se indica por parámetro. 
	 * Devolverá la respuesta del servicio 
	 * @param city
	 * @return
	 */
	public Ciudad createCity(Ciudad city) throws  CiudadErrorException;
	
	
	
	
	
	/** Actualizará la ciudad indicada por parámetro invocando al servicio. 
	 * Actualizará todos los valores que lleguen en el objeto, aunque estén a null
	 * Si el servicio devuelve un 404, lanzaremos la excepción NotFoundException 
	 * @param city
	 */
	public void updateCity(Ciudad city)  throws CiudadNoEncontradaException, CiudadErrorException;
	

	
	
	/** Actualizará la ciudad indicada por parámetro invocando al servicio. 
	 * Actualizará sólo los valores que lleguen informados en el objeto, es decir,
	 * los atributos que vengan a NULL, no se actualizan 
	 * Si el servicio devuelve un 404, lanzaremos la excepción NotFoundException 
	 * @param city
	 * @return
	 * @throws NotFoundException
	 */
	public Ciudad updateSelectiveCity(Ciudad city)  throws CiudadNoEncontradaException, CiudadErrorException;
	
	
	
	
	
	/** Borrará la ciudad indicada por parámetro invocando al servicio. 
	 * Si el servicio devuelve un 404, lanzaremos la excepción NotFoundException 
	 * @param id
	 */
	public void deleteCity(Long id)  throws CiudadNoEncontradaException, CiudadErrorException;

}
