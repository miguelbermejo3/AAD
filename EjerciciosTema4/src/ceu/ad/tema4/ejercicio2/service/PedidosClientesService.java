package ceu.ad.tema4.ejercicio2.service;

import ceu.ad.tema4.ejercicio2.modelo.*;

public interface PedidosClientesService {

	/** Debe crear en bbdd el cliente indicado. Si el cliente incorpora una lista de pedidos,
	 * estos no deben de registrarse en la BBDD. 	 */
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException;
	
	/** Debe crear en bbdd el pedido indicado. En el pedido, el cliente tiene que estar
	 * previamente registrado, así como los artículos de las líneas. Al guardar el pedido, 
	 * guardaremos también todas sus líneas. Devolverá el pedido registrado completo.
	 * IMPORTANTE: todas las l�neas del pedido habrá que inicializarlas con su n�mero
	 * de línea antes de guardarlas. Se inicializarán comenzando en 1 */
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException;
	
	/** Debe crear en bbdd el artículo indicado. Devolverá el articulo registrado completo. */
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException;


	/** Actualizará los datos del cliente indicado en BBDD. Sólo se actualizarán los datos
	 * de esta entidad, no de sus pedidos.	 */
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException;

	
	/** Consulta el cliente con el DNI indicado en BBDD. Si no existe, lanza NotFoundException
	 * Si existe, devolverá dicho cliente con todos sus pedidos cargados.
	 */
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException;

	/** Consulta el articulo con el ID indicado en BBDD. Si no existe, lanza NotFoundException
	 * Si existe, devolverá dicho artículo.	 */
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException;

	/** Consulta el pedido con el uuid indicado. Si no existe, lanzará NotFoundExcepion.
	 * El pedido devuelto estará completo: con todas sus líneas, artículos y cliente.	 */
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException;


	
}