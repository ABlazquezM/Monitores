package RestauranteSemaforosF;


public class Servicio {

	public static void main(String[] args) {
		
		int numeroClientes = (int)(Math.random()*40);
		Restaurante restaurante = new Restaurante();
		Cliente[] listaCleintes = new Cliente[numeroClientes];
		
		
		
		for (int i = 1;i<numeroClientes;i++) {
			listaCleintes[i] = new Cliente(restaurante,i);
			try {
				Thread.sleep((int)(Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listaCleintes[i].start();
		}
		
		for (int i = 1;i<numeroClientes;i++) {
			try {
				listaCleintes[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\nEl restaurante ha atendido a "+restaurante.getNumeroTotalClientesAtendidos()+" en el día de hoy");
		
	}

}
