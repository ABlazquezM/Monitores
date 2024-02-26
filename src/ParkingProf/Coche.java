package ParkingProf;

import java.util.Random;

public class Coche extends Thread {
	
	private static final int MAX_DELAY = 2000; // Tiempo máximo de espera antes de intentar entrar o salir del parking
	private int id; // Identificador único del coche
	private Barrera barrera; // Referencia a la barrera del parking

	// Constructor de la clase Coche
	public Coche(int id, Barrera bar) {
		this.id = id; // Asigna el identificador único del coche
		this.barrera = bar; // Asigna la referencia a la barrera del parking
	}

	// Método run() que se ejecuta cuando el hilo del coche se inicia
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(MAX_DELAY)); // El coche espera un tiempo aleatorio antes de intentar
															// entrar

			System.out.println("Coche " + id + " intenta entrar en el parking");
			int plaza = barrera.entrada(id); // El coche intenta entrar al parking, obteniendo el número de plaza
												// asignada

			System.out.println("Coche " + id + " aparcado en " + plaza);
			barrera.imprimir(); // Imprime el estado actual del parking

			Thread.sleep(new Random().nextInt(MAX_DELAY)); // El coche espera un tiempo aleatorio antes de intentar
															// salir
			barrera.salida(plaza); // El coche sale del parking, liberando su plaza

			System.out.println("Coche " + id + " saliendo");
			barrera.imprimir(); // Imprime el estado actual del parking después de la salida del coche
		} catch (InterruptedException e) {
			e.printStackTrace(); // Maneja cualquier interrupción durante la ejecución del hilo
		}
	}
}
