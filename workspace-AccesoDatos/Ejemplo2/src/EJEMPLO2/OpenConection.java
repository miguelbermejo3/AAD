package EJEMPLO2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConection {

	public Connection getNewConnection()   {
	
	String urlConexion = ":jdbc:mariadb://localhost:3306/Ejemplo2";
	String claseDriver = ":org.mariadb.jdbc.Driver";
	String usuario ="sakila";
	String password= "sakila";
	
	
	
	try {
		Class.forName(claseDriver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	Connection conn = null;
	try {
		conn = DriverManager.getConnection(urlConexion,usuario,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	
	return conn;
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
