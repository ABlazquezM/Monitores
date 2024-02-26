package bancoSemaforosF;

import java.util.concurrent.Semaphore;

public class Banco {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(2); // Tenemos dos ventanillas

		for (int i = 1; i < 10; i++) {
			AccesoVentanilas cliente = new AccesoVentanilas(semaforo, i);
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cliente.start();
		}
	}

}
