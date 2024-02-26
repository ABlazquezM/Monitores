package productorConsumidor;

public class Fabrica {

	public static void main(String[] args) {

		//Cuarta clase que se crea, con el main
		
		//Creamos el objeto compartido
		
		Productos productos = new Productos(10);
		Productor productor = new Productor(productos, "Productor");
		Consumidor consumidor = new Consumidor(productos, "Consumidor");
		
		//El productor empieza antes la jornada
		productor.start();
				try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consumidor.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productor.cerrar();
		consumidor.cerrar();
		
		try {
			consumidor.join();
			productor.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int p = productor.getnProducidos();
		int c = consumidor.getnConsumidos();
		int z = p-c;
		System.out.println("\nSe han producido "+p);
		System.out.println("Se han recogido "+c);
		System.out.println("Han quedado en la cesta "+z+" productos por recoger");
	}

}
