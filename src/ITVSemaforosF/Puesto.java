package ITVSemaforosF;

public class Puesto extends Thread {

	private int identif; // Identificador del puesto
	private ITV itv; // Referencia a la ITV
	private Integer tiempoPuesto; // Tiempo total que el puesto ha estado activo

	public Puesto(int identif, ITV itv) {
		this.identif = identif; // Asignar el identificador del puesto
		this.itv = itv; // Asignar la referencia a la ITV
		this.tiempoPuesto = 0; // Inicializar el tiempo del puesto en cero
	}

	// Método que se ejecuta cuando se inicia el hilo del puesto
	public void run() {
		int retardo;
		int numeroCoche;
		// Mientras haya coches pendientes en la ITV...
		while (itv.isCochesPendientes()) {
			try {
				retardo = (int) (Math.random() * 90 + 10); // Generar un retardo aleatorio entre 10 y 99
				tiempoPuesto += retardo; // Sumar el retardo al tiempo total del puesto
				numeroCoche = itv.terminarCoche(retardo); // Finalizar la inspección de un coche en la ITV con el
															// retardo generado
				sleep(retardo); // Simular el tiempo de inspección
				// Imprimir mensaje indicando la inspección realizada por el puesto
				System.out.println("El puesto " + identif + " ha revisado el coche " + numeroCoche + " en un tiempo de "
						+ retardo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Imprimir mensaje indicando el fin de actividad del puesto y su tiempo total
		// de trabajo
		System.out.println("Fin del puesto " + identif + ", que termina con un tiempo parcial de " + tiempoPuesto);
	}

}
