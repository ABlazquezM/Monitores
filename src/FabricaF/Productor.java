package FabricaF;

public class Productor extends Thread{
	
	private Cesta cesta;
	private int articulosProducidos = 0;
	private boolean abierto = true;
	
	public Productor(Cesta cesta) {
		this.cesta = cesta;
	}

	public int getArticulosProducidos() {
		return articulosProducidos;
	}
	
	public void cerrar() {
		abierto = false;
	}
	
	public void run() {
		while(abierto) {
			cesta.agregar();
			articulosProducidos++;
		}
	}
	

}
