package proyecto.app;

import java.math.BigDecimal;
import java.time.LocalDate;

import proyecto.modelo.Registro;
import proyecto.service.RegistroService;
import proyecto.service.fctException;

public class Test {

	
	public static void main(String[] args) {
		

		
	RegistroService rs=new RegistroService();
	Registro r= new Registro();
	r.setDescripcion("abfads");
	r.setFecha(LocalDate.now());
	r.setIdUsuario((long) 3);
	r.setNumHoras(new BigDecimal(3));
	try {
		rs.crearRegistroUsuario(r);
	} catch (fctException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
		
		
	}

}
