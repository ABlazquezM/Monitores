package ParkingF;

public class BarreraSalida extends Thread {

	Plazas plazas;
	private boolean abierto = true;

	public BarreraSalida(Plazas plazas) {
		this.plazas = plazas;
	}

	public void run() {
		while (abierto) {
			char plazaLibre = plazas.salir();
			System.out.println("Un coche abandona el parking dejando libre la plaza " + plazaLibre);

			try {
				sleep((int) (Math.random() * 8000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\nEl señor contador de plazas abandona su puesto");
	}

	public void cerrar() {
		abierto = false;
	}

}
