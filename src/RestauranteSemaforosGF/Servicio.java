package RestauranteSemaforosGF;

public class Servicio {
	
	public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente(i, restaurante);
            cliente.start();
            try {
                Thread.sleep((int) (Math.random() * 2000)); // Intervalo aleatorio entre llegadas de clientes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
