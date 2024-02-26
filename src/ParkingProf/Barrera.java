package ParkingProf;

public class Barrera {
	
    private int plazas[]; // Array que representa el estado de ocupación de las plazas del parking
    private int n_plazas;
    private int libres; // Variables para el número total de plazas y el número de plazas libres

    // Constructor de la clase Barrera
    public Barrera(int N) {
        n_plazas = N; // Asigna el número total de plazas
        plazas = new int[N]; // Inicializa el array de plazas con el tamaño especificado
        
        for (int i = 0; i < n_plazas; i++) {
            plazas[i] = 0; // Inicializa todas las plazas como vacías (0 representa una plaza vacía)
        }
        libres = n_plazas; // Inicializa el número de plazas libres como igual al número total de plazas
    }

    // Método synchronized para la entrada de un coche al parking
    synchronized public int entrada(int coche) throws InterruptedException {
        int plaza = 0; // Variable para almacenar la plaza asignada al coche

        imprimir(); // Imprime el estado actual del parking

        // Espera hasta que haya plazas libres en el parking
        while (libres == 0) {
            System.out.println("Coche " + coche + " esperando");
            wait(); // Se bloquea el hilo hasta que se notifique un cambio en el estado de la barrera
        }

        // Encuentra la primera plaza libre disponible
        while (plazas[plaza] != 0) {
            plaza++; // Avanza al siguiente índice en el array de plazas
        }

        plazas[plaza] = coche; // Asigna la plaza al coche
        libres--; // Decrementa el número de plazas libres

        return plaza; // Retorna el número de la plaza asignada al coche
    }

    // Método synchronized para la salida de un coche del parking
    synchronized public void salida(int plaza) {
        plazas[plaza] = 0; // Marca la plaza como vacía
        libres++; // Incrementa el número de plazas libres
        notify(); // Notifica a cualquier hilo en espera que hay un cambio en el estado de la barrera
    }

    // Método para imprimir el estado actual del parking
    public void imprimir() {
        System.out.println("Parking: ");
        for (int i = 0; i < n_plazas; i++) {
            System.out.println("[" + plazas[i] + "] "); // Imprime el estado de cada plaza (ocupada/vacía)
        }
        System.out.println("");
    }
}
