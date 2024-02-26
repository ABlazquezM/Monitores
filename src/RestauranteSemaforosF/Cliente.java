package RestauranteSemaforosF;

public class Cliente extends Thread{
	
	private Restaurante restaurante;
	private int id;

	
	public Cliente(Restaurante restaurante, int id) {
		super();
		this.restaurante = restaurante;
		this.id = id;
	}
	
	public void run() {

		try {			
			sleep((int)(Math.random()*4000));
			System.out.println("El cliente "+id+" ha llegado al restaurante, esta esperando a su mesa");
			restaurante.sentarse(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
