package EJEMPLO2;

import java.util.List;

public class App {

	public static void main(String[] args) {

		Service service = new Service();
		List<Actor> actores = service.consultarActores();
		for (Actor actor : actores) {
			System.out.println(actor);
		}

	}

}
