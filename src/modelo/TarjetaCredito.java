package modelo;

public class TarjetaCredito extends Producto{
	
	private double saldoMaximo;
	
	public TarjetaCredito(Cliente cliente, boolean vigencia, String identificadorProducto, double saldo, double deuda, int clave, double saldoMaximo) {
		super(cliente, vigencia, identificadorProducto, saldo, deuda, clave);
		this.saldoMaximo = saldoMaximo;
	}
	
	/**
	 * @return the saldoMaximo
	 */
	public double getSaldoMaximo() {
		return saldoMaximo;
	}
	/**
	 * @param saldoMaximo the saldoMaximo to set
	 */
	public void setSaldoMaximo(double saldoMaximo) {
		this.saldoMaximo = saldoMaximo;
	}
	
	
}
