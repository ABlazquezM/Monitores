package ITVSemaforosF;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class ITV {

	private Semaphore semaforo; // Semáforo para controlar el acceso a la lista de coches
	private PriorityQueue<Integer> listaCoches; // Cola de prioridad para almacenar los números de identificación de los
												// coches
	private Integer tiempoTotal; // Tiempo total utilizado para inspeccionar todos los coches

	// Constructor de la clase ITV
	public ITV() {
		semaforo = new Semaphore(1); // Inicialización del semáforo con un permiso inicial de 1
		listaCoches = new PriorityQueue<Integer>(); // Inicialización de la cola de prioridad
		tiempoTotal = 0; // Inicialización del tiempo total
	}

	// Método para agregar un nuevo coche a la cola de prioridad
	public void nuevoCoche(Integer numeroCoche) {
		try {
			semaforo.acquire(); // Adquirir el semáforo antes de realizar la operación
			listaCoches.add(numeroCoche); // Agregar el número de identificación del coche a la cola de prioridad
			semaforo.release(); // Liberar el semáforo después de completar la operación
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Método para finalizar la inspección de un coche
	public int terminarCoche(Integer tiempoParcial) {
		int coche = 0;
		try {
			if (isCochesPendientes()) { // Verificar si hay coches pendientes en la cola de prioridad
				semaforo.acquire(); // Adquirir el semáforo antes de realizar la operación
				coche = listaCoches.poll(); // Sacar el primer coche de la cola de prioridad
				tiempoTotal += tiempoParcial; // Actualizar el tiempo total utilizado
				semaforo.release(); // Liberar el semáforo después de completar la operación
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return coche; // Devolver el número de identificación del coche que ha finalizado la
						// inspección
	}

	// Método para verificar si hay coches pendientes en la cola de prioridad
	public boolean isCochesPendientes() {
		return listaCoches.size() > 0; // Devolver true si la cola de prioridad no está vacía, de lo contrario false
	}

	// Método para obtener el tiempo total utilizado para inspeccionar todos los
	// coches
	public Integer getTiempoTotal() {
		return tiempoTotal; // Devolver el tiempo total
	}
}
