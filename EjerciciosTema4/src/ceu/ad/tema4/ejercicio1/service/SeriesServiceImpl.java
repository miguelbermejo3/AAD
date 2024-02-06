package ceu.ad.tema4.ejercicio1.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import ceu.ad.tema4.ejercicio1.hibernate.HibernateUtil;
import ceu.ad.tema4.ejercicio1.modelo.Serie;
import jakarta.persistence.PersistenceException;

public class SeriesServiceImpl implements SeriesService {

	/**
	 * Consulta la serie con el id indicado por parámetro y la devuelve. Tiene que
	 * incluir todas sus entidades asociadas. Si la serie no existe, se lanzará
	 * SerieNotFoundException. Si hay cualquier otro error, se lanzará
	 * SeriesServiceException
	 */
	@Override
	public Serie consultarSerie(Long idSerie) throws SerieNotFoundException, SeriesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession(); 

			Serie serie = session.get(Serie.class, idSerie);
			
			if (serie == null) {
				throw new SerieNotFoundException("No existe la serie con id " + idSerie);
			}
			return serie;
		}
		catch (PersistenceException e) {
			System.err.println("Error consultando serie: " + e.getMessage());
			e.printStackTrace();
			throw new SeriesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/**
	 * Consultará todas las series que contengan en su descripción la palabra
	 * indicada en el filtro por parámetro. Si no se encuentra ninguna, lanzará
	 * SerieNotFoundException. Si hay cualquier otro error, se lanzará
	 * SeriesServiceException
	 */
	@Override
	public List<Serie> buscarSeries(String filtroDescripcion) throws SerieNotFoundException, SeriesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession(); 

			String sql = "select * from serie where descripcion like '%" + filtroDescripcion + "%'";
			NativeQuery<Serie> query = session.createNativeQuery(sql, Serie.class);
			List<Serie> resultados = query.getResultList();
			
			
			if (resultados.isEmpty()) {
				throw new SerieNotFoundException("No existen series con el filtro indicado: " + filtroDescripcion);
			}
			return resultados;
		} 
		catch (PersistenceException e) {
			System.err.println("Error consultando series: " + e.getMessage());
			e.printStackTrace();
			throw new SeriesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/**
	 * Debe crear la serie y todas sus entidades asociadas en bbdd. Si hay algún
	 * error, lanzará SeriesServiceException. Devolverá la serie creada con todos
	 * sus datos completos.
	 */
	@Override
	public Serie crearSerie(Serie serie) throws SeriesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession(); 
			session.getTransaction().begin();
			session.persist(serie);
			session.getTransaction().commit();
			return serie;
		} 
		catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error registrando nueva serie: " + e.getMessage());
			e.printStackTrace();
			throw new SeriesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close(); 
			}
		}

	}

	@Override
	public void elimnarSerie(Long idSerie) throws SeriesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession(); 

			session.getTransaction().begin();
			Serie serie = session.get(Serie.class, idSerie);
			session.remove(serie);
			session.getTransaction().commit();
			
		} 
		catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error borrando serie: " + e.getMessage());
			e.printStackTrace();
			throw new SeriesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void actualizarSerie(Serie serie) throws SeriesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			session.merge(serie);
			session.getTransaction().commit();
		} 
		catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error actualizando serie: " + e.getMessage());
			e.printStackTrace();
			throw new SeriesServiceException(e);
		} 
		finally {
			if (session != null) {
				session.close(); 
			}
		}
	}

}
