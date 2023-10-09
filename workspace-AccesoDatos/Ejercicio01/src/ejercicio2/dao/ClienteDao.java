package ejercicio2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio2.modelo.Cliente;

public class ClienteDao {

	public List<Cliente> consultarClientes(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from customer");

			while (rs.next()) {

				Cliente c = new Cliente();
				c.setId(rs.getInt("customer_id"));
				c.setNombre(rs.getString("first_name"));
				c.setApellido(rs.getString("last_name"));
				c.setCorreo(rs.getString("email"));
				c.setActivo(rs.getBoolean("active"));

				clientes.add(c);
			}

		}

		finally {

			try {
				stmt.close();
			} catch (Exception e) {
			}

		}

		return clientes;

	}

}