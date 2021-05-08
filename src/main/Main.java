package main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.*;
import utilidades.Util;

public class Main {

	/**
	 * Se utilizan los rut de los clientes creados a travez del metoro
	 * rellenarListaClientes(); su clave de acceso son los caracteres desde el 0 al
	 * 4 de cada rut
	 * 
	 * Alex Castillo: "17999999" Andres Calamaro: "18000000" Rodrigo Tapia :
	 * "18000001"
	 */

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";

	static ArrayList<Producto> productos = new ArrayList<>();
	static ArrayList<Cliente> clientes = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		rellenarListaClientes();
		rellenarListaProductos();
		Cliente cliente = menuIngresoCliente();
		menuPrincipal(cliente);

	}

	/**
	 * Una vez identificado el cliente se tienen 3 opciones donde se uso switch para
	 * cada una.
	 * 
	 */
	private static void menuPrincipal(Cliente cliente) {

		boolean salir = false;
		while (!salir) {
			Util.greenMsj("Que deseas hacer ?");
			Util.msj("1- Menu Cuenta Corriente");
			Util.msj("2- Menu Tarjeta de Credito");
			Util.msj("3- Salir");

			int opcion = 0;
			while (opcion <= 0 || opcion > 3) {
				try {
					opcion = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					Util.redMsj("Opcion no valida.");
					opcion = 0;
				}
			}

			switch (opcion) {
			case 1:
				Util.menu(cliente, (CuentaCorriente) buscarProductoCliente(1, cliente.getRut()));
				break;
			case 2:
				Util.menu(cliente, (TarjetaCredito) buscarProductoCliente(2, cliente.getRut()));
				break;
			case 3:
				salir = true;
				Util.greenMsj("Hasta luego " + cliente.getNombre());
				break;

			}

		}

	}

	/**
	 * Metodo de acceso a aplicacion, una vez confirmada la identiad del cliente se
	 * redireccionara hacia el metodo menuPrincipal()
	 * 
	 */

	private static Cliente menuIngresoCliente() {
		Cliente cliente = null;
		while (null == cliente) {
			Util.greenMsj("Ingrese su rut sin dv, sin puntos ni guion");
			try {
				String rut = sc.nextLine();
				if (!rut.isEmpty()) {
					Util.greenMsj("Ingrese su clave");
					int clave = Integer.parseInt(sc.nextLine());
					Util.msj(". . .\n");
					cliente = buscarClientePorRutYClave(rut, clave);

				} else {
					Util.redMsj("Rut no valido.");
				}
			} catch (NumberFormatException e) {
				Util.redMsj("Clave incorrecta");
			}
		}
		return cliente;
	}

	private static Cliente buscarClientePorRutYClave(String rut, int clave) {
		boolean rutEncontrado = false;
		for (Cliente clienteAux : clientes) {
			if (clienteAux.getRut().equals(rut)) {
				Util.msj( "Bienvenido " + clienteAux.getNombre());
				rutEncontrado = true;
				return clienteAux;
			}
		}
		if (!rutEncontrado) {
			Util.redMsj("No se ha encontrado el cliente");
		}
		return null;
	}

	private static Producto buscarProductoCliente(int productoDeseado, String rut) {

		boolean rutEncontrado = false;
		for (Producto productoAux : productos) {
			if (productoAux.getCliente().getRut().equals(rut)) {
				rutEncontrado = true;
				if (productoDeseado == 1 && productoAux instanceof CuentaCorriente) {
					return productoAux;
				}
				if (productoDeseado == 2 && productoAux instanceof TarjetaCredito) {
					return productoAux;
				}

			}
		}
		if (!rutEncontrado) {
			Util.redMsj("No se ha encontrado la cuenta");
		}
		return null;
	}

	private static void rellenarListaProductos() {
		for (Cliente cliente : clientes) {
			double saldoAlAzar = Math.floor(Math.random() * 100000);
			double porcentajeDeudaTarjeta = Math.floor((saldoAlAzar * 0.05));
			productos.add(new CuentaCorriente(cliente, true, "00-" + cliente.getRut(), saldoAlAzar, 15000,
					Integer.parseInt(cliente.getRut().substring(0, 4)), (saldoAlAzar * 0.05)));
			productos.add(
					new TarjetaCredito(cliente, true, "01-" + cliente.getRut(), saldoAlAzar - porcentajeDeudaTarjeta,
							porcentajeDeudaTarjeta, Integer.parseInt(cliente.getRut().substring(0, 4)), saldoAlAzar));
		}
	}

	/**
	 * Metodo para rellenar la lista de los clientes.
	 */
	@SuppressWarnings("deprecation")
	private static void rellenarListaClientes() {
		clientes.add(new Cliente(new Date(1994, 10, 28), "Alex", "Castillo", "17999999"));
		clientes.add(new Cliente(new Date(1994, 11, 05), "Andres", "Calamaro", "18000000"));
		clientes.add(new Cliente(new Date(1994, 12, 01), "Rodrigo", "Tapia", "18000001"));
	}
}
