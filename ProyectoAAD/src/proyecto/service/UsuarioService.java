package proyecto.service;

import java.sql.Connection;
import java.sql.SQLException;

import proyecto.dao.UsuarioDao;

import proyecto.modelo.Usuario;

public class UsuarioService {

	private OpenConnection openConn;

	public UsuarioService() {
		openConn = new OpenConnection();
	}

	public Usuario login(String correo, String pass) throws fctException, autenticarUsuarioException {
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

	public void altaUsuario(Usuario user) throws fctException, autenticarUsuarioException {

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
