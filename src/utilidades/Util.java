package utilidades;

import modelo.Cliente;
import modelo.CuentaCorriente;
import modelo.TarjetaCredito;
import main.Main;

public class Util {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	/**
	 * Se creo el metodo msj para acortar la tipografia de "System.out.println()"
	 * 
	 * @param msj
	 */
	public static void msj(String msj) {
		System.out.println(msj);
	}

	public static void greenMsj(String msj) {
		System.out.println(ANSI_GREEN + msj + ANSI_RESET);
	}

	public static void redMsj(String msj) {
		System.out.println(ANSI_RED + msj + ANSI_RESET);
	}

	public static void menu(Cliente cliente, TarjetaCredito tarjeta) {

		boolean salir = false;
		while (!salir) {
			greenMsj("- - - - - - - -");
			msj(ANSI_GREEN + "Tarjeta de credito: " + ANSI_RESET + tarjeta.getIdentificadorProducto());
			msj(ANSI_GREEN + "Saldo actual: "+ ANSI_RESET + tarjeta.getSaldo() + " / " + tarjeta.getSaldoMaximo());
			boolean tieneDeuda = tarjeta.getDeuda() > 0;
			if (tieneDeuda) {
				msj(ANSI_RED + "La deuda de su tarjeta de credito es: " + ANSI_RESET + tarjeta.getDeuda());
			} else {
				greenMsj("No tienes deuda.");
			}
			greenMsj("Que desea hacer ?");
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
				greenMsj("Volviendo al menu");
				salir = true;
				break;
			case 2:
			default:
				if (tarjeta.getSaldo() > tarjeta.getDeuda()) {
					tarjeta.setSaldo(tarjeta.getSaldo()-tarjeta.getDeuda());
					tarjeta.setDeuda(0);
					greenMsj("Su deuda ha sido pagada, volviendo al menu de tarjeta.");
				}else {
					redMsj("No a sido posible pagar su deuda, saldo insuficiente");
				}
				
				break;
			}

		}
	}

	public static void menu(Cliente cliente, CuentaCorriente cuenta) {

		boolean salir = false;
		while (!salir) {
			greenMsj("- - - - - - - -");
			msj(ANSI_GREEN + "Cuenta Corriente: " + ANSI_RESET + cuenta.getIdentificadorProducto());
			msj(ANSI_GREEN + "Saldo actual: " + ANSI_RESET + cuenta.getSaldo());
			boolean tieneDeuda = cuenta.getDeuda() > 0;
			if (tieneDeuda) {
				msj(ANSI_RED + "La deuda de su cuenta es: "+ ANSI_RESET + cuenta.getDeuda());
			} else {
				greenMsj("No tienes deuda.");
			}
			greenMsj("Que desea hacer ?");
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
				greenMsj("Volviendo al menu");
				salir = true;
				break;
			case 2:
				greenMsj("Cunto desea retirar ? (0 para cancelar)");
				double aRetirar = -1;
				while (aRetirar < 0) {
					try {
						aRetirar = Double.parseDouble(Main.sc.nextLine());
						cuenta.setSaldo(cuenta.getSaldo() - aRetirar);
						greenMsj("Dinero retirado, volviendo al menu de cuenta corriente.");
					} catch (Exception e) {
						opcion = -1;
					}
				}
				break;
			case 3:
			default:
				
				if (cuenta.getSaldo() > cuenta.getDeuda()) {
					cuenta.setSaldo(cuenta.getSaldo()-cuenta.getDeuda());
					cuenta.setDeuda(0);
					greenMsj("Su deuda ha sido pagada, volviendo al menu de cuenta corriente.");
				}else {
					redMsj("No a sido posible pagar su deuda, saldo insuficiente");
				}
				break;
			}

		}
	}

}
