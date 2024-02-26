package Puente;

public class Carretera {
	
	private boolean abierta = true;
	private int numeroDeCoches = 0;
	
	
	
	public int getNumeroDeCoches() {
		return numeroDeCoches;
	}

	public synchronized void acesoNorte() {
		if(!abierta) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		abierta = false;
		System.out.println("Hay un coche entrando por el Norte");
		numeroDeCoches++;
		notify();
		try {
			Thread.sleep((int)(Math.random()*5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abierta = true;
		System.out.println("El coche del norte terminó de pasar");
		notify();
	}
	
	public synchronized void accesoSur() {
		if(!abierta) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		abierta = false;
		System.out.println("Hay un coche entrando por el Sur");
		numeroDeCoches++;
		notify();
		
		try {
			Thread.sleep((int)(Math.random()*5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abierta = true;
		System.out.println("El coche del sur terminó de pasar");
		notify();
	}

}
