package ParquePublicoF;

public class Parque {

	public static void main(String[] args) {

		Visitantes visitante = new Visitantes();
		
		Torno t1 = new Torno(visitante,"Trono 1");
		Torno t2 = new Torno(visitante,"Trono 2");
		Torno t3 = new Torno(visitante,"Trono 3");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep((int)(Math.random()*15000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.cerrado();
		t2.cerrado();
		t3.cerrado();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Han pasado por el "+t1.getName()+" "+t1.getVisitantesPorTorno()+" visitantes");
		System.out.println("Han pasado por el "+t2.getName()+" "+t2.getVisitantesPorTorno()+" visitantes");
		System.out.println("Han pasado por el "+t3.getName()+" "+t3.getVisitantesPorTorno()+" visitantes");
		
		System.out.println("\nEn el día de hoy han entrado "+visitante.getContadorDeVisitantes()+" vistantes en el parque");
	}

}
