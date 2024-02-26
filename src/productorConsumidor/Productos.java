package productorConsumidor;

public class Productos {

	// Primero creamos la clase compartida

	// Vamos a crear un array de caracteres simulando los productos
	private char[] cestaProductos;

	private int siguiente;
	// Un boolenao para controlar que la cesta de productos está vacía y el
	// consumidor no pueda recoger
	private boolean estaVacia;
	// Y otro booleano para que cuando esté llega el productor deje de producir
	private boolean estaLlena;

	// Creamos el constructor con la capadidad de la cesta.
	public Productos(int capacidad) {
		// Este creará el array del tamaño que se pase
		this.cestaProductos = new char[capacidad];
		this.siguiente = 0;
		// Arranca la cesta en vacía
		this.estaVacia = true;
		// y por lo tanto no está llena
		this.estaLlena = false;
	}

	// Vamos a crear métodos sincronizados

	// Creamos el método de consimir
	public synchronized char consumir() {
		//Indicamos que si está vacía el consumidor no puede consimir
		while(this.estaVacia) {
			try {
				//Es por eso que debemos esperar
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		//Cuando estamos consumiento tenemos que quitarle a siguiente un valor
		siguiente --;
		//Al haber consimido al menos uno la cesta no está llena
		this.estaLlena = false;

		//Para controlar que el array está vacíon indicamos
		if(siguiente == 0) {
			//Si siguiente es 0 quiere decir que el array está vacío
			this.estaVacia = true;
			
		}
		//Debemos notificarlo 
		notify();
		//Devolvemos ese caracter
		return this.cestaProductos[this.siguiente];

	}

	// y creamos el de producir
	public synchronized void producir(char c) {
		while (this.estaLlena) {
			// Cuando esté llena debemos añadir un wait, para que se espere
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Añadimos un producto en la posicion del array, arrancando por 0
		cestaProductos[siguiente] = c;
		// Aumentamos el uno el contador para que se añada en la siguiente posición del
		// array la próxima vez
		siguiente++;
		// Como ya hems añadido uno la cesta ya no está vacía
		this.estaVacia = false;
		// Controlamos que si el contador es igual a la longitud del array debemos
		// indicar que la cesta está llena
		if (siguiente == this.cestaProductos.length) {
			this.estaLlena = true;
		}
		//notificamos que los que están esperando deben continuar
		notify();
	}
}
