package EstacionamientoSemaforosG;

import java.util.concurrent.Semaphore;

class Estacionamiento {
	private static final int NUMERO_PLAZAS = 10;
	private Semaphore semaforoPlazas = new Semaphore(NUMERO_PLAZAS);

	public void autoLlega(int idAuto) {
		System.out.println("Auto " + idAuto + " llega al estacionamiento.");
		try {
			semaforoPlazas.acquire();
			System.out.println("Auto " + idAuto + " encuentra una plaza disponible y se estaciona.");
			Thread.sleep((int) (Math.random() * 3000)); // Simula el tiempo que el auto está estacionado
			System.out.println("Auto " + idAuto + " termina de usar la plaza y la libera.");
			semaforoPlazas.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
