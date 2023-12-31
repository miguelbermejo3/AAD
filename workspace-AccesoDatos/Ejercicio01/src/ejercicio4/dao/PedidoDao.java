package ejercicio4.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import ejercicio4.modelo.Pedido;

public class PedidoDao {

	public void insertar(Connection conn, Pedido pedido) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "insert into pedidos (id_pedido, fecha_pedido, fecha_entrega, cliente) values (?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, pedido.getIdPedido());
			stmt.setDate(2, Date.valueOf(pedido.getFechaPedido()));
			stmt.setDate(3, Date.valueOf(pedido.getFechaEntrega()));
			stmt.setString(4, pedido.getCliente());
			stmt.execute();
		}
		finally {
			try {
				stmt.close();
			}catch(Exception ignore) {}
		}
	}

}
