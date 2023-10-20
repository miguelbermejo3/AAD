package proyecto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.dao.RegistroDao;
import proyecto.modelo.Registro;

public class RegistroService {

	private OpenConnection openConn;
	private List<Registro> listadoRegistro;

	public RegistroService() {
		openConn = new OpenConnection();
	}

	public List<Registro> consultarRegistroUsuario(Long idUsuario) throws fctException, autenticarUsuarioException {
		Connection conn = null;
		RegistroDao rd = new RegistroDao();
		try {
			conn = openConn.getNewConnection();

			listadoRegistro = rd.consultarPorUsuario(conn, idUsuario);

		} catch (SQLException e) {
			System.out.println("error al consultar el registro");
			throw new fctException("error en BBDD");
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
		return listadoRegistro;

	}

	public void crearRegistroUsuario(Registro registro) throws fctException {
		Connection conn = null;
		RegistroDao rd = new RegistroDao();
		List<Registro> registros = new ArrayList<Registro>();
		Boolean existe = false;
		try {
			conn = openConn.getNewConnection();

			registros = rd.consultarPorUsuario(conn, registro.getIdUsuario());

			for (Registro registro2 : registros) {

				if (registro2.getFecha() == registro.getFecha()) {
					existe = true;
				}

			}
			if (!existe) {
				rd.insertar(conn, registro);
			}

		} catch (SQLException e) {
			System.out.println("error en la BBD");
			throw new fctException("Ya existe el registro para dicho usuario o no existe dicho usuario en la BBDD", e);

		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

	}
	
	
	
	

}
