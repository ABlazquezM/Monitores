package ParquePublicoF;

public class Torno extends Thread{
	
	private Visitantes visitante;
	private int visitantesPorTorno = 0;
	private boolean tornoAbierto = true;
	
	public Torno(Visitantes visitante,String nombre) {
		super(nombre);
		this.visitante = visitante;
	}
	
	public void cerrado() {
		tornoAbierto = false;
	}
	
	
	
	public int getVisitantesPorTorno() {
		return visitantesPorTorno;
	}

	public void run() {
		while(tornoAbierto) {
			visitante.entraVisitante();
			System.out.println("\nHa entrado el visitante "+visitante.getContadorDeVisitantes()+" por el "+getName());
			visitantesPorTorno++;
			try {
				sleep((int)(Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
