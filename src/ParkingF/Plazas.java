package ParkingF;

public class Plazas {

	private char[] numeroDePlaza = new char[10];
	private int siguiente = 0;

	private boolean vacio = true;
	private boolean lleno = false;

	public Plazas() {
	}

	public int getSiguiente() {
		return siguiente;
	}

	public char[] getNumeroDePlaza() {
		return numeroDePlaza;
	}

	public synchronized void entrar(char plaza) {
		if (lleno) {
			System.out.println("\nEl parking está lleno");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		numeroDePlaza[siguiente] = plaza;
		siguiente++;
		vacio = false;

		if (siguiente == numeroDePlaza.length) {
			lleno = true;
		}
		notifyAll();

	}

	public synchronized char salir() {
		while (vacio) {
			System.out.println("\nEl parking está vacío");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		siguiente--;
		lleno = false;

		if (siguiente == 0) {
			vacio = true;
		}
		notifyAll();
		return numeroDePlaza[siguiente];

	}

}
