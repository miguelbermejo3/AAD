package proyecto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proyecto.dao.RegistroDao;
import proyecto.modelo.Registro;

@RestController
public class RegistroService {

	private OpenConnection openConn;
	private List<Registro> listadoRegistro;

	public RegistroService() {
		openConn = new OpenConnection();
	}

	@GetMapping("/registro/usuario/{idUsuario}")
	public List<Registro> consultarRegistroUsuario(@PathVariable Long idUsuario)
			throws fctException {
		Connection conn = null;
		RegistroDao rd = new RegistroDao();
		try {
			System.out.println("consultando registros con id " + idUsuario);
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

	@PostMapping("/registro")
	public void crearRegistroUsuario(@RequestBody Registro registro) throws fctException{
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
					throw new fctException("el registro ya existe");
				}

			}
			if (!existe) {
				rd.insertar(conn, registro);
			}

		} catch (SQLException e) {
			System.out.println("error en la BBD");
			throw new fctException("Ya existe el registro para dicho usuario ", e);

		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

	}

}
