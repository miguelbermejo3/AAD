package ejercicio4.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejercicio01.service.OpenConnection;
import ejercicio4.dao.LineaPedidoDao;
import ejercicio4.dao.PedidoDao;
import ejercicio4.modelo.LineaPedido;
import ejercicio4.modelo.Pedido;

public class PedidoService {

	private OpenConnection connProvider;

	public PedidoService() {
		connProvider = new OpenConnection();
	}

	public void crearPedido(Pedido pedido) throws PedidoServiceException {
		PedidoDao daoPedido = new PedidoDao();
		LineaPedidoDao daoLinea = new LineaPedidoDao();
		Connection conn = null;
		try {
			conn = connProvider.getNewConnection();
			conn.setAutoCommit(false);

			daoPedido.insertar(conn, pedido);

			List<LineaPedido> lineas = pedido.getLineas();
			int numLinea = 1;
			for (LineaPedido linea : lineas) {

				linea.setIdPedido(pedido.getIdPedido());
				linea.setNumLinea(numLinea);
				daoLinea.insertar(conn, linea);
				numLinea++;
			}
			conn.commit();
		} catch (SQLException e) {
			System.err.println("Error al registrar pedido");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.err.println("No se ha podido hacer rollback");
			}
			throw new PedidoServiceException("Error al registrar pedido", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}
