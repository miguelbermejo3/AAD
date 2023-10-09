package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

public Connection getNewConnection() throws SQLException {
		
		String driverClass = "org.mariadb.jdbc.Driver";
		String urlConexion = "jdbc:mariadb://localhost:3306/sakila";
		
		String usuario = "sakila";
		String password = "sakila";

		

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			System.err.println("No se encuentra el driver JDBC. Revisa su configuracion");
			throw new RuntimeException(e);
		}

		Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
		return conn;
	}

}
