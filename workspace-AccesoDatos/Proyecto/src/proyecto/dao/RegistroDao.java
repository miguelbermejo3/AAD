package proyecto.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.modelo.Registro;

public class RegistroDao {

	public List<Registro> consultarRegistroUsuario(Connection conn, Long idUsuario) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		Registro registro = new Registro();
		List<Registro> registros = new ArrayList<>();
		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from registros where id_usuario = " + idUsuario);
			while (rs.next()) {

				registro.setDescripcion(rs.getString("descripcion"));
				registro.setFecha(rs.getDate("fecha").toLocalDate());
				registro.setIdRegistro(rs.getLong("id_registro"));
				registro.setIdUsuario(rs.getLong("id_usuario"));
				registro.setNumHoras(rs.getBigDecimal("num_horas"));
				registros.add(registro);

			}

			return registros;

		} finally {

			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}

	}

	public void insertarRegistro(Connection conn, Registro registro) throws SQLException {

		PreparedStatement stmt = null;

		try {

			String sql = "insert into registros (id_registro, id_usuario, fecha, num_horas,descripcion) values (?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, registro.getIdRegistro());
			stmt.setLong(2, registro.getIdUsuario());
			stmt.setDate(3, Date.valueOf(registro.getFecha()));
			stmt.setBigDecimal(4, registro.getNumHoras());
			stmt.setString(5, registro.getDescripcion());
			stmt.execute();

		} finally {

			try {
				stmt.close();
			} catch (Exception ignore) {
			}

		}

	}

}
