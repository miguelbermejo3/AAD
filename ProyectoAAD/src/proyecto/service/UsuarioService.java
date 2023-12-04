package proyecto.service;

import java.sql.Connection;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyecto.dao.UsuarioDao;

import proyecto.modelo.Usuario;


@RestController
public class UsuarioService {

	private OpenConnection openConn;

	public UsuarioService() {
		openConn = new OpenConnection();
	}

	
	
	@GetMapping("/usuario")
	public Usuario login( @RequestParam  String correo, @RequestParam  String pass) throws fctException, autenticarUsuarioException {
		Connection conn = null;
		UsuarioDao ud = new UsuarioDao();
		Usuario usuario = new Usuario();

		try {

			conn = openConn.getNewConnection();
			usuario = ud.consultarUsuario(conn, correo);

			if (usuario == null) {
				System.out.println("no existe el usuario");
				throw new autenticarUsuarioException("no existe el usuario");
			}
			if(!usuario.getContraseña().equals(pass)) {
				System.out.println("contraseña incorrecta");
				throw new autenticarUsuarioException("La contraseña es incorrecta");
			}
			
			
			else {
				
				return usuario;
			}

		} catch (SQLException e) {

			System.out.println("Error al consultar el usuario");
			throw new fctException("error en BBDD");

		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {

			}
		}

	}

	
	
	@PostMapping("/usuario")
	public void altaUsuario(@RequestBody  Usuario user) throws fctException, autenticarUsuarioException {

		Connection conn = null;
		UsuarioDao ud = new UsuarioDao();
		Usuario usuario = new Usuario();

		try {

			conn = openConn.getNewConnection();
			usuario = ud.consultarUsuario(conn, user.getCorreo());

			if (usuario == null) {
				ud.insertarUsuario(conn, user);
			} else {
				throw new autenticarUsuarioException("ya existe el usuario");
			}

		} catch (SQLException e) {

			throw new fctException("error en BBDD", e);
		} finally {

			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

	}
	


}
