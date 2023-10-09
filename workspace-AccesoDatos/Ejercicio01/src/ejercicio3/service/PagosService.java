package ejercicio3.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio01.service.OpenConnection;
import ejercicio2.dao.ClienteDao;
import ejercicio2.modelo.Cliente;
import ejercicio3.dao.PagoDao;
import ejercicio3.modelo.Pago;

public class PagosService {
	private OpenConnection openConn;

	public PagosService() {
		openConn = new OpenConnection();
	}

	public Map<String, List<Pago>> consulta() throws PagosException {
		Connection conn = null;
		ClienteDao cd = new ClienteDao();
		Map<String, List<Pago>> pago = new HashMap<>();
		try {
			conn = openConn.getNewConnection();
			List<Cliente> clientes = cd.consultarClientes(conn);
			PagoDao pd = new PagoDao();

			for (Cliente cliente : clientes) {
				List<Pago> pagos = pd.consultarClientes(conn, cliente.getId());

				pago.put(cliente.getCorreo(), pagos);

			}

		} catch (SQLException e) {
			System.out.println("error al obtener pagos");
			throw new PagosException ("error al obtener lista pagos",e) ;
			
		}

		finally {

			try {
				conn.close();
			} catch (SQLException e) {

			}

		}

		return pago;

	}

}
