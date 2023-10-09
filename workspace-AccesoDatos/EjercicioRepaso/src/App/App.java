package App;

import java.util.Scanner;

import Service.ActoresService;
import Service.ActoresServiceException;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		consultarActor();

		sc.close();
	}

	private static void consultarActor() {

		ActoresService as = new ActoresService();

		try {
			as.consultarActores();
		} catch (ActoresServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
