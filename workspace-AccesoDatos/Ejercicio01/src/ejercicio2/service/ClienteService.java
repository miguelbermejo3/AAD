package ejercicio2.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio01.service.OpenConnection;

import ejercicio2.dao.ClienteDao;
import ejercicio2.modelo.Cliente;

public class ClienteService {
	private OpenConnection openConn;

	public ClienteService() {
		openConn = new OpenConnection();
	}

	public Map<String, Cliente> consultarClientes() throws ClienteServiceException {

		Connection conn = null;
		Map<String, Cliente> mapa = null;
		try {
			conn = openConn.getNewConnection();
			ClienteDao dao = new ClienteDao();

			List<Cliente> clientes = dao.consultarClientes(conn);
			mapa = new HashMap<>();
			for (Cliente cliente : clientes) {
				mapa.put(cliente.getCorreo(), cliente);

			}
			return mapa;
		}

		catch (SQLException e) {

			System.out.println("ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new ClienteServiceException("Error al obtener datos de la bbd", e);

		}

		finally {

			try {
				conn.close();
			} catch (Exception e) {
			}

		}

	}
}
