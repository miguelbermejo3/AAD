package service;

import java.util.ArrayList;
import java.util.List;

import modelo.Asignatura;

public class AsignaturaService {

	public AsignaturaService() {
	
	}
	
	public List<Asignatura>consultarAsignatura(){
		List<Asignatura>lista= new ArrayList<>();
		for(int i=0;i<=100;i++) {
			Asignatura a= new Asignatura();
			if(i%2==0) {
				a.setCiclo("DAM");
			}
			else {
				a.setCiclo("DAW");
			}
		
			a.setNombre("ejemplo asignatura "+i);
			a.setId(i);
			lista.add(a);
		}
	
	return lista;
	}

}
