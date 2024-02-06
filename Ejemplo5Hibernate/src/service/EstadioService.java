package service;

import org.hibernate.Session;

import ejemplo.jpa.HibernateUtil;
import jakarta.persistence.PersistenceException;
import modelo.Estadio;

public class EstadioService {

	public EstadioService() {

	}

	public void insertarEEstadio(Estadio e) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			session.persist(e);// coge el equipo e hibernate lo inserta
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

	public void actualizarEstadio(Estadio e) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			session.merge(e);// coge el equipo e hibernate lo actualiza
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

	public void eliminarEstadio(Estadio e) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			session.remove(e);// coge el equipo e hibernate lo elimina
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

	public Estadio consultarEstadio(Long id) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			Estadio e = session.get(Estadio.class, id);// coge el equipo e hibernate lo elimina
			return e;

		} catch (PersistenceException ex) {
			session.getTransaction().rollback();

			throw ex;
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
