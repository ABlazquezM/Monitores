package ParqueProfe;

public class Main {
    public static void main(String[] args) {
    	
        Parque parque = new Parque();

	    Puerta puerta1 = new Puerta(parque);
	    Puerta puerta2 = new Puerta(parque);
	    Puerta puerta3 = new Puerta(parque);
	    
	    puerta1.start();
	    puerta2.start();
	    puerta3.start();
	    
	    parque.getCuenta();

    }
}