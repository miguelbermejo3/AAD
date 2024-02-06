package ejemplo.jpa;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import modelo.Equipo;
import modelo.Estadio;
import modelo.Jugador;
import modelo.Socio;

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
			ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(registry)
					// Aquí añadimos las entidades que queremos mapear
					.addAnnotatedClass(Equipo.class).addAnnotatedClass(Estadio.class).addAnnotatedClass(Jugador.class).addAnnotatedClass(Socio.class).getMetadataBuilder().build();
			sessionFactoy = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

}
