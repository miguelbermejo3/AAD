package App;

import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import modelo.Estadio;
import modelo.Jugador;
import modelo.Socio;
import service.EquipoService;
import service.EstadioService;

public class App {

	public static void main(String[] args) {
		EstadioService es = new EstadioService();
		EquipoService eqs = new EquipoService();

		// Esto es para insertar
		Equipo e = new Equipo();
		e.setNombre("Betis");
		e.setNumJugadores(13);
		Estadio est = new Estadio();
		est.setNombre("estadio Benito Villamarín");
		est.setDireccion("AV La Palmera");

		e.setEstadio(est);

		e.setJugadores(new ArrayList<Jugador>());
		List<Socio> socios = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Jugador jugador = new Jugador();
			jugador.setCodigo("COD" + i + 6);
			jugador.setDorsal(22);
			jugador.setNombre("isco");
			jugador.setEquipo(e);
			e.getJugadores().add(jugador);
		}

		for (int i = 0; i < 3; i++) {
			Socio socio = new Socio();
			socio.setNombre("mismo");
			socios.add(socio);

		}
		e.setSocios(socios);
		eqs.insertarEquipo(e);

		// para actualizar:
		/*
		 * Equipo e = new Equipo(); e.setId((long) 1); e.setNombre("Bulls");
		 * e.setNumJugadores(11); EquipoService es= new EquipoService();
		 * es.actualizarequipo(e);
		 */
		// para eliminar
		/*
		 * Equipo e = new Equipo(); e.setId((long) 1); EquipoService es= new
		 * EquipoService(); es.eliminarEquipo(e);
		 * 
		 */
		// para consultar
//		Equipo equipo=new Equipo();
//		equipo = eqs.consultarEquipo((long) 6);
//		System.out.println("\n>>> Equipo consultado: " + equipo);
//		System.out.println("  >> Jugadores: " + equipo.getJugadores());

	}
}
