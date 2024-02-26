package PabellonSemaforosF;

public class Equipo extends Thread {

	private Caja caja;
	private int id;

	public Equipo(Caja caja, int id) {
		this.caja = caja;
		this.id = id;
	}

	public void run() {
		caja.cojerBalon(id);
	}

}
