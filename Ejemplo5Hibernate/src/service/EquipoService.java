package service;

import org.hibernate.Session;

import ejemplo.jpa.HibernateUtil;
import jakarta.persistence.PersistenceException;
import modelo.Equipo;

public class EquipoService {

	public EquipoService() {

	}

	public void insertarEquipo(Equipo e) {

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

	public void actualizarequipo(Equipo e) {

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

	public void eliminarEquipo(Equipo e) {

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

	public Equipo consultarEquipo(Long id) {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			Equipo e = session.get(Equipo.class, id);// coge el equipo e hibernate lo elimina
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
