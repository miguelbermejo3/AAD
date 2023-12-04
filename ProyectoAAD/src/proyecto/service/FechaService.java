package proyecto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.dao.FechaDao;
import proyecto.modelo.Fecha;

@RestController
public class FechaService {
	private FechaDao dao;
	private OpenConnection connProvider;

	public FechaService() {
		dao = new FechaDao();
		connProvider = new OpenConnection();
	}

	@GetMapping("/fecha")
	public List<Fecha> consultarFechasActuales() throws SQLException,fctException  {
		LocalDate hoy = LocalDate.now();
		Connection conn = null;
		Integer evaluacion = 1;
		try {
			conn = connProvider.getNewConnection();
			
			
			if (hoy.getMonthValue() >= 9) {
				evaluacion = 1;
			}
			return dao.consultar(conn, hoy.getYear(), evaluacion);
		} catch (SQLException e) {
			System.err.println("Error al consultar fechas");
			throw new fctException("error en la bbd fct",e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
		
		
	}
}
