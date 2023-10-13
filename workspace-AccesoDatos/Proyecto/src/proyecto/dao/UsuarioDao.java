package proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proyecto.modelo.Usuario;

public class UsuarioDao {

	
	public Usuario consultarUsuario(Connection conn, String correo) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from usuarios where email= '" + correo+"'");
			if (rs.next()) {

				
				usuario.setCorreo(rs.getString("email"));
				usuario.setContraseña(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellidos"));
				usuario.setCiclo(rs.getString("ciclo"));
				usuario.setActivo(rs.getBoolean("activo"));
				return usuario;
			}
			else {
				return null;
			}
			
		} finally {
			try {
				stmt.close();
			}

			catch (Exception ignore) {
			}
		}

	}

	public void insertarUsuario(Connection conn, Usuario usuario) throws SQLException {

		PreparedStatement stmt = null;

		try {

			String sql = "insert into usuarios ( email, password, nombre,apellidos,ciclo,activo) values (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getCorreo());
			stmt.setString(2, usuario.getContraseña());
			stmt.setString(3, usuario.getNombre());
			stmt.setString(4, usuario.getApellido());
			stmt.setString(5, usuario.getCiclo());
			stmt.setBoolean(6, usuario.getActivo());
			stmt.execute();

		} finally {

			try {
				stmt.close();
			} catch (Exception ignore) {
			}

		}

	}

}
