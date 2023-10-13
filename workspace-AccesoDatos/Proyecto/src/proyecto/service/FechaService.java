package proyecto.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import proyecto.dao.FechaDao;
import proyecto.modelo.Fecha;

public class FechaService {
	private OpenConnection openConn;
	private List<Fecha>listaFechas;
	
	public FechaService() {
		openConn = new OpenConnection();
	}
	
	public List<Fecha>consultarFechasActuales(){
		FechaDao fd=new FechaDao();
		
		Connection conn=null;
		
		try {
			int evaluacion=0;
			if(LocalDate.now().getMonthValue()>=9&&LocalDate.now().getMonthValue()<=11) {
				evaluacion=1;
			}
			else if(LocalDate.now().getMonthValue()>=12&&LocalDate.now().getMonthValue()<=2) {
				evaluacion=2;
			}
			else if(LocalDate.now().getMonthValue()>=3&&LocalDate.now().getMonthValue()<=5) {
				evaluacion=3;
			}
			
			
			listaFechas=fd.consultarFecha(conn,LocalDate.now().getYear(),evaluacion,true);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			
			try {
				conn.close();
			}catch(Exception ignore) {}
		}
		
		
		
		return listaFechas;
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
