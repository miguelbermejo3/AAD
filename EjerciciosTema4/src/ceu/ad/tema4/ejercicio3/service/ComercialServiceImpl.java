package ceu.ad.tema4.ejercicio3.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import ceu.ad.tema4.ejercicio3.jpa.HibernateUtil;
import ceu.ad.tema4.ejercicio3.modelo.CentroComercial;
import ceu.ad.tema4.ejercicio3.modelo.Marca;
import ceu.ad.tema4.ejercicio3.modelo.Pais;
import ceu.ad.tema4.ejercicio3.modelo.Tienda;
import jakarta.persistence.PersistenceException;

public class ComercialServiceImpl implements ComercialService {

	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession(); 

			String sql = "select * from pais where descripcion like '" + filtro + "%'";
			NativeQuery<Pais> query = session.createNativeQuery(sql, Pais.class);
			List<Pais> resultados = query.getResultList();
		
			return resultados;
		} 
		catch (PersistenceException e) {
			System.err.println("Error buscando pais: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void insertarMarca(Marca marca) throws ComercialException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(marca);
			session.getTransaction().commit();

		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error insertando marca: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
		
			session.persist(cc);
			session.getTransaction().commit();

		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error insertando centro comercial: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public CentroComercial consultarCentroComercial(String uuidCentro) throws ComercialException, NotFoundException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
// aqui hacemos la insercion !!
			CentroComercial cc= session.get(CentroComercial.class, UUID.fromString(uuidCentro));
			session.getTransaction().commit();
			if (cc==null) {
				throw new NotFoundException("Centro comercial no encontrado");
			}
			return cc;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error consultando cenctro comercial: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	

	@Override
	public Tienda consularTienda(Long idTienda) throws ComercialException, NotFoundException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession(); 

			Tienda tienda = session.get(Tienda.class, idTienda);
			
			if (tienda == null) {
				throw new NotFoundException("Tienda no encontrada");
			}
			return tienda;
		}
		catch (PersistenceException e) {
			System.err.println("Error consultando tienda: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void borrarTienda(Long idTienda) throws ComercialException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession(); 

			session.getTransaction().begin();
			 Tienda t=session.get(Tienda.class, idTienda);
			session.remove(t);
			session.getTransaction().commit();
			
		} 
		catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error borrando tienda: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
// aqui hacemos la insercion !!
			CentroComercial cc=session.get(CentroComercial.class, UUID.fromString(uuidCentro));
			session.remove(cc);
			session.getTransaction().commit();
		
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error borrando centro comercial: " + e.getMessage());
			e.printStackTrace();
			throw new ComercialException(e);
		
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
