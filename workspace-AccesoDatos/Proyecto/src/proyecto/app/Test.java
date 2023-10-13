package proyecto.app;

import proyecto.modelo.Usuario;
import proyecto.service.UsuarioService;
import proyecto.service.autenticarUsuarioException;
import proyecto.service.fctException;

public class Test {

	
	public static void main(String[] args){
		
		
		UsuarioService us=new UsuarioService();
		Usuario usuario=new Usuario();
		
		usuario.setActivo(true);
		usuario.setApellido("bermejo");
		usuario.setCiclo("DAM");
		usuario.setContraseña("miguel");
		usuario.setCorreo("miguelb@gmail.com");
		usuario.setNombre("miguel");
		
		
		try {
			us.altaUsuario(usuario);
		} catch (fctException e) {
			
			e.printStackTrace();
		} catch (autenticarUsuarioException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
