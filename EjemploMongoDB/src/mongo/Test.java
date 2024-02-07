package mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import modelo.Direccion;
import modelo.Persona;

public class Test {
	public static void main(String[] args) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas",Persona.class);
		
		Persona p= new Persona();
		p.setDni("77847654Z");
		p.setNombre("Miguel");
		p.setEdad(24);
		p.getDirecciones().add(new Direccion("avd reino unido","sevlila",41012));
		
		InsertOneResult result=c.insertOne(p);
		
	}
}
