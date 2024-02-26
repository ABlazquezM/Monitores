package FabricaF;

public class Consumidor extends Thread{
	
	private Cesta cesta;
	private int articulosRecogidos = 0;
	private boolean abierto = true;
	
	public Consumidor(Cesta cesta) {
		this.cesta = cesta;
	}

	public int getArticulosProducidos() {
		return articulosRecogidos;
	}
	
	public void cerrar() {
		abierto = false;
	}
	
	public void run() {
		while(abierto) {
			cesta.recoger();
			articulosRecogidos++;
		}
	}

}
