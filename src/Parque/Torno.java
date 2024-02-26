package Parque;

public class Torno extends Thread{
	

	private Visitantes visitante;
	private int visitantesPorTorno = 0; 
	private boolean abierto = true;

	public Torno(Visitantes visitante,String nombre) {
		super(nombre);
		this.visitante = visitante;
	}
	
	
	
	public int getVisitantesPorTorno() {
		return visitantesPorTorno;
	}

	public synchronized void cerrar() {
		abierto = false;
	}




	public void run() {
		 synchronized (visitante) {
			
		} while(abierto) {
			visitante.sumarVisitante();
			System.out.println("El visitante "+visitante.getTotalVisitas()+" ha pasado por el torno "+getName());
			visitantesPorTorno++;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Han pasado "+getVisitantesPorTorno()+" por el trono "+getName());
		
	}
	
	
	
	

}
