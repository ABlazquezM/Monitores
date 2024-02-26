package ParqueProfe;

public class Puerta extends Thread {
	
    private  Parque parque;

    public Puerta(Parque parque) {
        this.parque = parque;
    }
    

    public void run() {
        for (int i = 0; i < 10; i++) {
        	synchronized (parque) {
        		parque.sumarVisitante();
                System.out.println(getName()+" - "+parque.getCuenta());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
        }
    }
}
