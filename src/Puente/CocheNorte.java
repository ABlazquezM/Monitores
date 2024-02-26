package Puente;

public class CocheNorte extends Thread{
	
	private Carretera carretera;
	private boolean abiertoAlTrafico = true;
	
	

	public CocheNorte(Carretera carretera) {
		this.carretera = carretera;
	}
	
	public void cerrar() {
		abiertoAlTrafico= false;
	}
	
	public void run() {
		while(abiertoAlTrafico) {
			carretera.acesoNorte();
		}
	}
	
	

}
