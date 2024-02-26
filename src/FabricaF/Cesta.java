package FabricaF;

public class Cesta {
	
	private int cuantos = 0;

	public Cesta() {
	}
	
	public synchronized void agregar() {
		if(cuantos == 10) {
			System.out.println("\n¡La cesta esta llena! No se pueden añadir mas productos");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep((int)(Math.random()*500));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cuantos++;
		System.out.println("Se ha AÑADIDO un producto a la cesta, tenemos "+this.cuantos+" productos");
		notify();
	}
	
	public synchronized void recoger() {
		if(cuantos == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep((int)(Math.random()*2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cuantos--;
		System.out.println("Se ha RECOGIDO un producto a la cesta, tenemos "+this.cuantos+" productos");
		notify();
	}
	
	

}
