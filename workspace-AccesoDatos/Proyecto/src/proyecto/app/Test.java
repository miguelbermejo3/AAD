package proyecto.app;


import java.math.BigDecimal;

import java.time.LocalDate;

import proyecto.modelo.Registro;
import proyecto.service.RegistroService;
import proyecto.service.autenticarUsuarioException;
import proyecto.service.fctException;

public class Test {

	
	public static void main(String[] args) throws autenticarUsuarioException{
		
	
		
RegistroService rs= new RegistroService();
Registro reg=new Registro();

reg.setDescripcion("sfgj");
reg.setFecha(LocalDate.of(2023, 10,13));
reg.setIdRegistro((long) 5);
reg.setNumHoras(new BigDecimal(3));
reg.setIdUsuario((long)1 );



try {
	//rs.crearRegistroUsuario(reg);
	System.out.println(rs.consultarRegistroUsuario((long)3));
} catch (fctException e) {
	
	e.printStackTrace();
}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
