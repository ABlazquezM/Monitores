package EstacionamientoSemaforosG;

public class Servicio {

	public static void main(String[] args) {
		Estacionamiento estacionamiento = new Estacionamiento();
		for (int i = 1; i <= 15; i++) {
			Auto auto = new Auto(i, estacionamiento);
			auto.start();
			try {
				Thread.sleep((int) (Math.random() * 2000)); // Intervalo aleatorio entre llegadas de autos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
