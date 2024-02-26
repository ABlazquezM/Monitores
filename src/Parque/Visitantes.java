package Parque;

public class Visitantes {
	
	private int totalVisitas = 0;

	public int getTotalVisitas() {
		return totalVisitas;
	}

	public synchronized void
	
	
	sumarVisitante() {
		totalVisitas++;
		System.out.println("El visitante "+getTotalVisitas()+" está en la cola.");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


}
