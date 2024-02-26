package PabellonSemaforosF;

public class Partido {

	public static void main(String[] args) {

		Caja caja = new Caja();
		int numeroEquipos = (int) (Math.random() * 40);

		Equipo[] arrayEquipos = new Equipo[numeroEquipos];

		for (int i = 0; i < numeroEquipos; i++) {
			arrayEquipos[i] = new Equipo(caja, i);
			try {
				Thread.sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			arrayEquipos[i].start();
		}

		for (int i = 0; i < numeroEquipos; i++) {
			try {
				arrayEquipos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		}

		System.out
				.println("\n__En el día de hoy se han jugado un total de " + caja.getPartidosJugados() + " partidos__");

	}

}
