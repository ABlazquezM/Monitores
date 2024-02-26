package productorConsumidor;

public class Productor extends Thread{
	
	//Segunda clase que hacemos, el uno de los hilos
	
	//Creamos un String con todos los caracteres
	private String letras = "abcdefghijklmnopqrstuvwxyz";
	
	//Cremos los productos para tener algo en comun
	private Productos productos;
	
	//Cremos un booleanos para indicar si la fábrica está abierta
	private boolean abierta = true;
	
	private int nProducidos = 0;
	
	
	public Productor(Productos productos, String nombre) {
		super(nombre);
		this.productos = productos;
	}
	

	public int getnProducidos() {
		return nProducidos;
	}



	//Añadimos el método 
	public void run() {
		while(abierta) {
			//Cogemos una letra aleatoria
			char c = letras.charAt((int)(Math.random() * letras.length()));
			productos.producir(c);
			System.out.println("El "+getName()+" ha depositado el caracter "+c+" en la cesta");
			nProducidos++;
			
			try {
				//Se quedará entre 0 y 4 segundos
				sleep((int)(Math.random() + 400));
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
