package ejercicio3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio3.modelo.Pago;

public class PagoDao {

	public PagoDao() {
	}

	public List<Pago> consultarClientes(Connection conn, Integer id) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		List<Pago> pagos = new ArrayList<>();

		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from payment where customer_id=" + id);

			while (rs.next()) {

				Pago p = new Pago();
				p.setFecha(rs.getDate("payment_date").toLocalDate());
				p.setImporte(rs.getBigDecimal("amount"));
				pagos.add(p);
			}
			return pagos;
		}

		finally {

			try {
				stmt.close();
			} catch (Exception e) {
			}

		}

	}

}
