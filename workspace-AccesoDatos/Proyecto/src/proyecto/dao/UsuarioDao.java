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

			rs = stmt.executeQuery("select * from usuarios where email=" + correo);
			while (rs.next()) {

				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setCorreo(rs.getString("email"));
				usuario.setContraseña(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellidos"));
				usuario.setCiclo(rs.getString("ciclo"));
				usuario.setActivo(rs.getBoolean("activo"));

			}
			return usuario;
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

			String sql = "insert into usuarios (id_usuario, email, password, nombre,apellidos,ciclo,acivo) values (?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, usuario.getIdUsuario());
			stmt.setString(2, usuario.getCorreo());
			stmt.setString(3, usuario.getContraseña());
			stmt.setString(4, usuario.getNombre());
			stmt.setString(5, usuario.getApellido());
			stmt.setString(6, usuario.getCiclo());
			stmt.setBoolean(7, usuario.getActivo());
			stmt.execute();

		} finally {

			try {
				stmt.close();
			} catch (Exception ignore) {
			}

		}

	}

}
