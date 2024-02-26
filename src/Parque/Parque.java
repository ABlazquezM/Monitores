package Parque;

public class Parque {

	public static void main(String[] args) {

		//Instaciamos el método compartido
		Visitantes visitante = new Visitantes();
		
		Torno torno1 = new Torno(visitante,"Torno 1");
		Torno torno2 = new Torno(visitante,"Torno 2");
		Torno torno3 = new Torno(visitante,"Torno 3");
		
		//Los inicializamos para que empiecen a ejecutarse cada uno de ellos
		torno1.start();
		torno2.start();
		torno3.start();
		
		//El tiemo que queremos que esté ejecutandose:
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Una vez pasado este tiempo cerramos el parque, paramos la ejecución
		torno1.cerrar();
		torno2.cerrar();
		torno3.cerrar();
		
		
		//Para poder imprimri la cantidad total. Si no lo ponemos, cuando pasen los 10 segunos, va a empezar a ejecutar 
		//lo siguiente, imprimiría el sisy antes de que acaben los procesoso, por eso necesitamos añadir el join
		//Para que sea vera lo debemos poner.
		
		try {
			torno1.join();
			torno2.join();
			torno3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total personas el el parque: "+visitante.getTotalVisitas());
	}

}
