package Service;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import Actores.Actor;
import Persistencia.ActoresPersistencia;

public class ActoresService {
	private OpenConnection openConn;

	public ActoresService() {
		openConn = new OpenConnection();
	}

	public List<Actor> consultarActores() throws ActoresServiceException  {

		Connection conn = null;

		try {
			conn = openConn.getNewConnection();
			ActoresPersistencia dao = new ActoresPersistencia();
			return dao.consultarActores(conn);
		}

		catch (SQLException e) {

			System.out.println("ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new ActoresServiceException("Error al obtener datos de la bbd", e);

		}

		finally {

			try {
				conn.close();
			} catch (Exception e) {
			}

		}

	}

}
