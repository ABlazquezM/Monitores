package ParkingF;

public class Parking {

	public static void main(String[] args) {

		Plazas plazas = new Plazas();
		BarreraEntrada e = new BarreraEntrada(plazas);
		BarreraSalida s = new BarreraSalida(plazas);

		e.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		s.start();

		try {
			Thread.sleep(20000);
		} catch (InterruptedException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		e.cerrar();

		try {
			e.join();
			s.cerrar();
			s.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Han entrado un total de " + e.getTotalCoches() + " en el día de hoy");

		System.out.println("Las plazas ocupadas en este momento son: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(plazas.getNumeroDePlaza()[i] + " ");
		}

	}

}
