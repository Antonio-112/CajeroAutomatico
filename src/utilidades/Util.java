package utilidades;

import modelo.Cliente;
import modelo.CuentaCorriente;
import modelo.TarjetaCredito;
import main.Main;

public class Util {

	/**
	 * Se creo el metodo msj para acortar la tipografia de "System.out.println()"
	 * @param msj
	 */
	public static void msj(String msj) {
		System.out.println(msj);
	}

	public static void menu(Cliente cliente, TarjetaCredito tarjeta) {

		boolean salir = false;
		while (!salir) {
			msj("- - - - - - - -");
			msj("Tarjeta de credito: " + tarjeta.getIdentificadorProducto());
			msj("Saldo actual: " + tarjeta.getSaldo() + " / " + tarjeta.getSaldoMaximo());
			boolean tieneDeuda = tarjeta.getDeuda() > 0;
			if (tieneDeuda) {
				msj("La deuda de su tarjeta de credito es: " + tarjeta.getDeuda());
			} else {
				msj("No tienes deuda.");
			}
			msj("Que desea hacer ?");
			msj("1. Volver al menu");
			int opcionMasAlta = 1;
			if (tieneDeuda) {
				msj("2. Pagar mi deuda");
				opcionMasAlta = 2;
			}
			int opcion = 0;
			while (opcion <= 0 || (opcion > opcionMasAlta)) {
				try {
					opcion = Integer.parseInt(Main.sc.nextLine());
				} catch (Exception e) {
					opcion = 0;
				}
			}

			switch (opcion) {
			case 1:
				msj("Volviendo al menu");
				salir = true;
				break;
			case 2:
			default:
				tarjeta.setDeuda(0);
				tarjeta.setSaldo(tarjeta.getSaldoMaximo());
				msj("Su deuda ha sido pagada, volviendo al menu de tarjeta.");
				break;
			}

		}
	}

	public static void menu(Cliente cliente, CuentaCorriente cuenta) {

		boolean salir = false;
		while (!salir) {
			msj("- - - - - - - -");
			msj("Cuenta Corriente: " + cuenta.getIdentificadorProducto());
			msj("Saldo actual: " + cuenta.getSaldo());
			boolean tieneDeuda = cuenta.getDeuda() > 0;
			if (tieneDeuda) {
				msj("La deuda de su cuenta es: " + cuenta.getDeuda());
			} else {
				msj("No tienes deuda.");
			}
			msj("Que desea hacer ?");
			msj("1. Volver al menu");
			msj("2. Retirar dinero");
			int opcionMasAlta = 2;
			if (tieneDeuda) {
				msj("3. Pagar mi deuda");
				opcionMasAlta = 3;
			}
			int opcion = 0;
			while (opcion <= 0 || (opcion > opcionMasAlta)) {
				try {
					opcion = Integer.parseInt(Main.sc.nextLine());
				} catch (Exception e) {
					opcion = 0;
				}
			}

			switch (opcion) {
			case 1:
				msj("Volviendo al menu");
				salir = true;
				break;
			case 2:
				msj("Cunto desea retirar ? (0 para cancelar)");
				double aRetirar = -1;
				while (aRetirar < 0) {
					try {
						aRetirar = Double.parseDouble(Main.sc.nextLine());
						cuenta.setSaldo(cuenta.getSaldo() - aRetirar);
						msj("Dinero retirado, volviendo al men� de cuenta corriente.");
					} catch (Exception e) {
						opcion = -1;
					}
				}
				break;
			case 3:
			default:
				cuenta.setDeuda(0);
				msj("Su deuda ha sido pagada, volviendo al men� de cuenta corriente.");
				break;
			}

		}
	}

}
