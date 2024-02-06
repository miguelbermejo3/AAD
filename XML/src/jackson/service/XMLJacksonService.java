package jackson.service;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ejemploHandle.modelo.Curso;
import ejemploHandle.service.CursosXMLException;

public class XMLJacksonService {

	public void escribirXMLCurso(String pathName, Curso curso) throws CursosXMLException {
		
		
		
		try {
			XmlMapper mapper= new XmlMapper();
			
			File file= new File(pathName);
			mapper.writeValue(file, curso);
		} catch (IOException e) {
			
			System.out.println("error al escribir xml de curso: "+e.getMessage());
			throw new CursosXMLException("Error escribiendo xml",e);
		}
		
		

	}

}
