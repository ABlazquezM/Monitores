package RestauranteSemaforosF;

import java.util.concurrent.Semaphore;

public class Restaurante {

	private Semaphore semaforo;
	private int numeroTotalClientesAtendidos = 0;

	public Restaurante() {
		super();
		this.semaforo = new Semaphore(5);
	}

	public int getNumeroTotalClientesAtendidos() {
		return numeroTotalClientesAtendidos;
	}

	public void sentarse(int id) {
		try {
			semaforo.acquire();
			System.out.println("El cliente " + id + " se ha sentado a comer");
			numeroTotalClientesAtendidos++;
			Thread.sleep((int) (Math.random() * 2000));
			semaforo.release();
			System.out.println("El cliente " + id + " ha terminado del comer y se marcha del restaurante");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
