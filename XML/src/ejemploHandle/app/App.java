package ejemploHandle.app;

import java.util.List;

import ejemploHandle.modelo.Curso;
import ejemploHandle.service.CursosXMLException;
import ejemploHandle.service.XMLCursoServices;

public class App {

	public static void main(String[] args) {
		testLeerXMLCursoSax();
	}

	private static void testLeerXMLCursoSax() {
		XMLCursoServices service = new XMLCursoServices();
		try {
			List<Curso> cursos=service.leerCursos("c:/temporal/cursos.xml");
			for (Curso curso : cursos) {
				System.out.println(curso);
			}
		} catch (CursosXMLException e) {

			e.printStackTrace();
		}

	}

}
