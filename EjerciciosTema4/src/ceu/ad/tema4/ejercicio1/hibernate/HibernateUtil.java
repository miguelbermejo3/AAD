package ceu.ad.tema4.ejercicio1.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import ceu.ad.tema4.ejercicio1.modelo.Episodio;
import ceu.ad.tema4.ejercicio1.modelo.Serie;
import ceu.ad.tema4.ejercicio1.modelo.Temporada;
import ceu.ad.tema4.ejercicio1.modelo.Trailer;

public class HibernateUtil {

	private static SessionFactory sessionFactoy;

	public static SessionFactory getSessionFactoy() {
		if (sessionFactoy == null) {
			init();
		}
		return sessionFactoy;
	}

	private static void init() {
		try {
			ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();
			Metadata metadata = new MetadataSources(registry)
					// Aquí añadimos las entidades que queremos mapear
					.addAnnotatedClass(Episodio.class).addAnnotatedClass(Serie.class).addAnnotatedClass(Temporada.class)
					.addAnnotatedClass(Trailer.class).getMetadataBuilder().build();
			sessionFactoy = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

}
