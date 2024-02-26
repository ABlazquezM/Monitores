package PabellonSemaforosF;

import java.util.concurrent.Semaphore;

public class Caja {

	private Semaphore semaforo;
	private int balonesDisponibles = 8;
	private int partidosJugados = 0;

	public Caja() {
		this.semaforo = new Semaphore(8);
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void cojerBalon(int id) {
		try {
			semaforo.acquire();
			balonesDisponibles--;
			System.out.println("El equipo nº: " + id + " ha cogido un balon de la caja, quedan " + balonesDisponibles
					+ " disponiles");
			Thread.sleep((int) (Math.random() * 6000));
			semaforo.release();
			balonesDisponibles++;
			partidosJugados++;
			System.out.println("\nEl equipo nº: " + id + " ha terminado el partido y deja el balón en la caja, tenemos "
					+ balonesDisponibles + " disponiles");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
