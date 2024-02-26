package ParkingProf;

public class Parking {

    public static void main(String[] args) {
        // Número de plazas en el parking
        int numPlazas = 5; 

        // Inicializar el parking
        Barrera barrera = new Barrera(numPlazas);

        // Número de coches que llegarán al parking
        int numCoches = 5; 
        Coche coches[] = new Coche[numCoches];

        // Crear e iniciar cada hilo de coche
        for (int i = 0; i < numCoches; i++) {
            coches[i] = new Coche(i + 1, barrera); // Crear un nuevo coche con un identificador único (i + 1) y la barrera compartida
            coches[i].start(); // Iniciar el hilo del coche
        }

        try {
            // Esperar a que todos los hilos de coche terminen
            for (int i = 0; i < numCoches; i++) {
                coches[i].join(); // Esperar a que el hilo del coche termine antes de continuar
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejar cualquier interrupción durante la espera
        }
    }
}