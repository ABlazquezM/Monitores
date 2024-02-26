package Puente;

public class Trafico {

	public static void main(String[] args) {

		Carretera c = new Carretera();
		CocheNorte n = new CocheNorte(c);
		CocheSur s = new CocheSur(c);
		
		
		n.start();
		s.start();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		n.cerrar();
		s.cerrar();
		
		try {
			n.join();
			s.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Han pasado por el puente un total de "+c.getNumeroDeCoches()+" coches.");
	}

}
