package modelo;

public class CuentaCorriente extends Producto {

	private double precioMensual;

	public CuentaCorriente(Cliente cliente, boolean vigencia, String identificadorProducto, double saldo, double deuda,
			int clave, double precioMensual) {
		super(cliente, vigencia, identificadorProducto, saldo, deuda, clave);
		this.precioMensual = precioMensual;
	}

	/**
	 * @return the precioMensual
	 */
	public double getPrecioMensual() {
		return precioMensual;
	}

	/**
	 * @param precioMensual the precioMensual to set
	 */
	public void setPrecioMensual(double precioMensual) {
		this.precioMensual = precioMensual;
	}

}
