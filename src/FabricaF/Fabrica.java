package FabricaF;

public class Fabrica {

	public static void main(String[] args) {

		Cesta cesta = new Cesta();
		Productor p = new Productor(cesta);
		Consumidor c = new Consumidor(cesta);
		
		p.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.start();
		
		
		try {
			Thread.sleep((int)(Math.random()*20000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.cerrar();
		c.cerrar();
		
		try {
			p.join();
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nSe han poducido "+p.getArticulosProducidos()+" en total.");
		System.out.println("Se han recogido "+c.getArticulosProducidos()+" en total.");
	}

}
