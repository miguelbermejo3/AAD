package ceu.ad.tema4.ejercicio2.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import ceu.ad.tema4.ejercicio2.modelo.Articulo;
import ceu.ad.tema4.ejercicio2.modelo.Cliente;
import ceu.ad.tema4.ejercicio2.modelo.Pedido;
import ceu.ad.tema4.ejercicio2.modelo.PedidoLinea;

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
			ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate2.cfg.xml").build();
			Metadata metadata = new MetadataSources(registry)
					// Aquí añadimos las entidades que queremos mapear
					.addAnnotatedClass(Articulo.class).addAnnotatedClass(Cliente.class).addAnnotatedClass(Pedido.class)
					.addAnnotatedClass(PedidoLinea.class).getMetadataBuilder().build();
			sessionFactoy = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
}
