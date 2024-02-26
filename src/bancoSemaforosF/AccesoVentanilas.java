package bancoSemaforosF;

import java.util.concurrent.Semaphore;

public class AccesoVentanilas extends Thread {

	private final Semaphore semaforo;
	private int id;

	public AccesoVentanilas(Semaphore semaforo, int id) {
		super();
		this.semaforo = semaforo;
		this.id = id;
	}

	@Override
	public void run() {

		System.out.println("Cliente " + id + " está esperando en la ventanilla");
		try {
			semaforo.acquire();
			System.out.println("Cliente " + id + " está siendo atendido");
			sleep((int) (Math.random() * +6000));
			System.out.println("Cliente " + id + " está saliendo del banco");
			semaforo.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
