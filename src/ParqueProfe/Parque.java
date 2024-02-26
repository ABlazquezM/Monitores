package ParqueProfe;

public class Parque {
	
    private int cuenta = 0;

    public int getCuenta() {
    	return cuenta;
    }
    
    public void sumarVisitante() {
        cuenta++;
        System.out.println("Alguien ha entrado al parque. Total: "+cuenta);
    }

}