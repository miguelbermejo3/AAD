package proyecto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import proyecto.dao.FechaDao;
import proyecto.modelo.Fecha;



public class FechaService {

	private FechaDao dao;
	private OpenConnection connProvider;

	public FechaService() {
		dao = new FechaDao();
		connProvider = new OpenConnection();
	}

	public List<Fecha> consultarFechasActuales() throws fctException {
		Connection conn = null;
		try {
			conn = connProvider.getNewConnection();
			LocalDate hoy = LocalDate.now();
			Integer evaluacion = 1;
			if (hoy.getMonthValue() >= 9) {
				evaluacion = 1;
			}
			return dao.consultar(conn, hoy.getYear(), evaluacion);
		} catch (SQLException e) {
			System.err.println("Error al consultar fechas");
			throw new fctException("Error al consultar fechas en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}