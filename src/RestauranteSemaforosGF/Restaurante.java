package RestauranteSemaforosGF;

import java.util.concurrent.Semaphore;

//Está mejor el otro

class Restaurante {
	private static final int NUMERO_MESAS = 5;
	private Semaphore semaforoMesas = new Semaphore(NUMERO_MESAS);

	public void clienteLlega(int idCliente) {
		System.out.println("Cliente " + idCliente + " llega al restaurante.");
		try {
			semaforoMesas.acquire();
			System.out.println("Cliente " + idCliente + " obtiene una mesa y se sienta.");
			Thread.sleep((int) (Math.random() * 3000)); // Simula el tiempo que el cliente está comiendo
			System.out.println("Cliente " + idCliente + " termina de comer y libera la mesa.");
			semaforoMesas.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
