package ITVSemaforosF;

public class Main {

	public static void main(String[] args) {
		// Generación de números aleatorios para la cantidad de puestos y vehículos
		int pueRandom = (int) (Math.random() * 4) + 1; // Número aleatorio entre 1 y 4 para la cantidad de puestos
		int vehRandom = (int) (Math.random() * 30) + 20; // Número aleatorio entre 20 y 49 para la cantidad de vehículos

		// Creación de la instancia de la ITV
		ITV itv = new ITV();

		// Impresión de la cantidad de vehículos y puestos que serán atendidos
		System.out.println(vehRandom + " Vehículos serán atendidos por " + pueRandom + " puestos.");

		// Creación de los vehículos
		Coche[] v = new Coche[vehRandom];
		for (int i = 0; i < vehRandom; i++) {
			v[i] = new Coche(i + 1, itv); // Cada vehículo se crea con un identificador único y la referencia a la ITV
			v[i].start(); // Se inicia el hilo del vehículo
		}

		// Creación de los puestos
		Puesto[] p = new Puesto[pueRandom];
		for (int i = 0; i < pueRandom; i++) {
			p[i] = new Puesto(i + 1, itv); // Cada puesto se crea con un identificador único y la referencia a la ITV
			p[i].start(); // Se inicia el hilo del puesto
		}

		// Se espera a que terminen todos los puestos
		for (int i = 0; i < pueRandom; i++) {
			try {
				p[i].join(); // Se espera a que el hilo del puesto termine su ejecución
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Se espera a que terminen todos los vehículos
		for (int i = 0; i < vehRandom; i++) {
			try {
				v[i].join(); // Se espera a que el hilo del vehículo termine su ejecución
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Se imprime el tiempo total acumulado de la ITV
		System.out.println("Se cierra la ITV con un tiempo acumulado de " + itv.getTiempoTotal());
	}
}
