package ceu.ad.tema4.ejercicio3.jpa;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import ceu.ad.tema4.ejercicio3.modelo.CentroComercial;
import ceu.ad.tema4.ejercicio3.modelo.Marca;
import ceu.ad.tema4.ejercicio3.modelo.Pais;
import ceu.ad.tema4.ejercicio3.modelo.Tienda;



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
			ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate3.cfg.xml").build();
			Metadata metadata = new MetadataSources(registry)
					// Aquí añadimos las entidades que queremos mapear
					.addAnnotatedClass(CentroComercial.class).addAnnotatedClass(Marca.class).addAnnotatedClass(Pais.class).addAnnotatedClass(Tienda.class).getMetadataBuilder().build();
			sessionFactoy = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
}
