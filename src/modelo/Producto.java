package modelo;

public class Producto {

	protected Cliente cliente;
	protected boolean vigencia;
	protected String identificadorProducto;
	protected double saldo;
	protected double deuda;
	protected int clave;

	public Producto(Cliente cliente, boolean vigencia, String identificadorProducto, double saldo, double deuda,
			int clave) {
		super();
		this.cliente = cliente;
		this.vigencia = vigencia;
		this.identificadorProducto = identificadorProducto;
		this.saldo = saldo;
		this.deuda = deuda;
		this.clave = clave;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @return the vigencia
	 */
	public boolean isVigencia() {
		return vigencia;
	}

	/**
	 * @return the identificadorProducto
	 */
	public String getIdentificadorProducto() {
		return identificadorProducto;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @return the clave
	 */
	public int getClave() {
		return clave;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

	/**
	 * @param identificadorProducto the identificadorProducto to set
	 */
	public void setIdentificadorProducto(String identificadorProducto) {
		this.identificadorProducto = identificadorProducto;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(int clave) {
		this.clave = clave;
	}

	/**
	 * @return the deuda
	 */
	public double getDeuda() {
		return deuda;
	}

	/**
	 * @param deuda the deuda to set
	 */
	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

}
