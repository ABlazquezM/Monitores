package ITVSemaforosF;

public class Coche extends Thread {

	private int identif; // Identificador del coche
	private ITV itv; // Referencia a la ITV

	// Constructor de la clase Coche
	public Coche(int identif, ITV itv) {
		this.identif = identif; // Asignar el identificador del coche
		this.itv = itv; // Asignar la referencia a la ITV
	}

	// Método que se ejecuta cuando se inicia el hilo del coche
	public void run() {
		itv.nuevoCoche(identif); // Agregar el coche a la ITV para su inspección
	}
}
