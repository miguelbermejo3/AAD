package ejercicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@EnableAutoConfiguration
public class ApiTest {

	public static void main(String[] args) {
		SpringApplication.run(ApiTest.class, args);
	}

}
