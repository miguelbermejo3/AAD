package ceu.ad.tema4.ejercicio2.service;

import java.util.UUID;

import org.hibernate.Session;

import ceu.ad.tema4.ejercicio2.hibernate.HibernateUtil;
import ceu.ad.tema4.ejercicio2.modelo.*;
import jakarta.persistence.PersistenceException;

public class PedidosClientesServiceImpl implements PedidosClientesService {

	/**
	 * Debe crear en bbdd el cliente indicado. Si el cliente incorpora una lista de
	 * pedidos, estos no deben de registrarse en la BBDD.
	 */
	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			session.persist(cliente);// coge al cliente e hibernate lo inserta
			session.getTransaction().commit();

		} catch (PersistenceException ex) {
			session.getTransaction().rollback();

			throw ex;
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/**
	 * Debe crear en bbdd el pedido indicado. En el pedido, el cliente tiene que
	 * estar previamente registrado, así como los artículos de las líneas. Al
	 * guardar el pedido, guardaremos también todas sus líneas. Devolverá el pedido
	 * registrado completo. IMPORTANTE: todas las líneas del pedido habrá que
	 * inicializarlas con su número de línea antes de guardarlas. Se inicializarán
	 * comenzando en 1
	 */

	@Override
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			for (int i = 0; i < pedido.getLineas().size(); i++) {
				pedido.getLineas().get(i).setNumLinea(i + 1);
			}

			session.getTransaction().begin();

			session.persist(pedido);
			session.getTransaction().commit();
			return pedido;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error registrando nueva serie: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Debe crear en bbdd el artículo indicado. Devolverá el articulo registrado
	 * completo.
	 */

	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			session.persist(articulo);// coge el artículo e hibernate lo inserta
			session.getTransaction().commit();
			return articulo;
		} catch (PersistenceException ex) {
			session.getTransaction().rollback();
			System.out.println("error al crear");
			ex.printStackTrace();
			throw new PedidosClientesServiceException();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/**
	 * Actualizará los datos del cliente indicado en BBDD. Sólo se actualizarán los
	 * datos de esta entidad, no de sus pedidos.
	 */
	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			session.merge(cliente);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error actualizando serie: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Consulta el cliente con el DNI indicado en BBDD. Si no existe, lanza
	 * NotFoundException Si existe, devolverá dicho cliente con todos sus pedidos
	 * cargados.
	 */

	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			Cliente cliente = session.get(Cliente.class, dni);

			if (cliente == null) {
				throw new NotFoundException("No existe la serie con id " + dni);
			}
			return cliente;
		} catch (PersistenceException e) {
			System.err.println("Error consultando serie: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/**
	 * Consulta el articulo con el ID indicado en BBDD. Si no existe, lanza
	 * NotFoundException Si existe, devolverá dicho artículo.
	 */

	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			Articulo articulo = session.get(Articulo.class, idArticulo);

			if (articulo == null) {
				throw new NotFoundException("No existe el articulo con id " + idArticulo);
			}
			return articulo;
		} catch (PersistenceException e) {
			System.err.println("Error consultando serie: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/**
	 * Consulta el pedido con el uuid indicado. Si no existe, lanzará
	 * NotFoundExcepion. El pedido devuelto estará completo: con todas sus líneas,
	 * artículos y cliente.
	 */
	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			Pedido pedido = session.get(Pedido.class, UUID.fromString(uuid));

			if (pedido == null) {
				throw new NotFoundException("No existe la serie con id " + uuid);
			}
			return pedido;
		} catch (PersistenceException e) {
			System.err.println("Error consultando serie: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
