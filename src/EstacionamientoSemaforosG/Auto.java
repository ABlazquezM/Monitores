package EstacionamientoSemaforosG;

class Auto extends Thread {
	private int idAuto;
	private Estacionamiento estacionamiento;

	public Auto(int idAuto, Estacionamiento estacionamiento) {
		this.idAuto = idAuto;
		this.estacionamiento = estacionamiento;
	}

	@Override
	public void run() {
		estacionamiento.autoLlega(idAuto);
	}
}