package productorConsumidor;

public class Consumidor extends Thread{
	
	//Tercera clase que hacemos, el uno de los hilos
	
	
	
	//Cremos los productos para tener algo en comun
	private Productos productos;
	
	//Cremos un booleanos para indicar si la fábrica está abierta
	private boolean abierta = true;
	
	private int nConsumidos = 0;
	
	
	
	public int getnConsumidos() {
		return nConsumidos;
	}

	public Consumidor(Productos productos, String nombre) {
		super(nombre);
		this.productos = productos;
	}

	//Añadimos el método 
	public void run() {
		while(abierta) {
			//
			
			System.out.println("El "+getName()+" ha recogido el producto "+this.productos.consumir()+"\n");
			nConsumidos++;
			try {
				//Se quedará entre 0 y 4 segundos
				sleep((int)(Math.random() + 600));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void cerrar() {
		abierta = false;
	}

}
