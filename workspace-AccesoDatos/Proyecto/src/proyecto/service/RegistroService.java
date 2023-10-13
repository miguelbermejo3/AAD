package proyecto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import proyecto.modelo.Registro;

public class RegistroService {

	private OpenConnection connProvider;

	public RegistroService() {
		connProvider = new OpenConnection();
	}
	
	public List<Registro>consultarRegistroUsuario(Long idUsuario){
		Connection conn=null;
		
		try {
		conn=connProvider.getNewConnection();
		}catch(SQLException e) {
			System.out.println("error al consultar el registro");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
