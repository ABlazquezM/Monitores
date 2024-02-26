package RestauranteSemaforosGF;

class Cliente extends Thread {
	private int idCliente;
	private Restaurante restaurante;

	public Cliente(int idCliente, Restaurante restaurante) {
		this.idCliente = idCliente;
		this.restaurante = restaurante;
	}

	@Override
	public void run() {
		restaurante.clienteLlega(idCliente);
	}
}