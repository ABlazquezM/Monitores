package ParquePublicoF;

public class Visitantes {
	
	private int contadorDeVisitantes = 0;
	

	public Visitantes() {
		
	}
	
	
	
	public int getContadorDeVisitantes() {
		return contadorDeVisitantes;
	}



	public synchronized void entraVisitante() {
		contadorDeVisitantes++;
		System.out.println("Ha llegado el visitante nº "+this.contadorDeVisitantes+" al parque");
		
	}

}
