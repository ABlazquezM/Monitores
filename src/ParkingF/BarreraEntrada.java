package ParkingF;

public class BarreraEntrada extends Thread {

	Plazas plazas;
	private int totalCoches = 0;
	private String numeroDePlaza = "01234567899";
	private boolean abierto = true;

	public BarreraEntrada(Plazas plazas) {
		this.plazas = plazas;
	}

	public int getTotalCoches() {
		return totalCoches;
	}

	public void run() {
		while (abierto) {
			char plaza = numeroDePlaza.charAt(plazas.getSiguiente());
			plazas.entrar(plaza);
			System.out.println("Ha entrado un coche y ha aparcado en la plaza número " + plaza);
			totalCoches++;

			try {
				sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void cerrar() {
		abierto = false;
	}

}
