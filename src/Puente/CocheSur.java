package Puente;

public class CocheSur extends Thread{
	
	private Carretera carretera;
	private boolean abiertoAlTrafico = true;
	
	

	public CocheSur(Carretera carretera) {
		this.carretera = carretera;
	}
	
	public void cerrar() {
		abiertoAlTrafico= false;
	}
	
	public void run() {
		while(abiertoAlTrafico) {
			carretera.accesoSur();
		}
	}
	
	

}
