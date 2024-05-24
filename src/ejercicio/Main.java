package ejercicio;

import java.util.Scanner;

public class Main {
	public static final int maxVec = 10;
	public static final int maxTransac = 50;
	
	public static final String fechaHoy = "24/05/2024";

	public static int menu(Scanner scan) {
		System.out.println("Bienvenido al sistema de Emergencias\n\n" + "1) A\n" + "2) B\n" + "3) C\n" + "0) Salir\n\n"
				+ "Opcion: ");
		int op = elegirOpcion(4, 0, scan);
		return op;
	}

	public static int elegirOpcion(int top, int bot, Scanner scan) {
		int opc = scan.nextInt();
		while (opc < bot || opc > top) {
			opc = scan.nextInt();
			if (opc < bot || opc > top) {
				System.err.println("\nOpcion fuera de rango. Elija un valor entre " + bot + " y " + top + ".");
			}
		}
		return opc;
	}

	public static void main(String[] args) {
		// ARTICULOS
		Articulo comput = new Computadora("RYZEN 3600, RTX 5500, 12 GB RAM", "AMD", 2324, "Computadora", 1200000);
        Articulo mouse = new Periferico("Mouse", "Logitech", 1233, "Logitech g-pro hero", 70000);
		
		// TIENDA
		Tienda tienda1 = new Tienda();
		tienda1.setNombre("DarioShop"); tienda1.setCuit("20-20042321-4"); tienda1.setSucursal(7);
		tienda1.setTransacciones(new Transaccion[maxTransac]); tienda1.setPedidosClientes(new Pedido[maxTransac]);
		// CLIENTE
		Cliente cl1 = new Cliente();
		cl1.setNombre("Passio"); cl1.setApellido("Passioti"); cl1.setDocumento(2345678);
		Pedido cl1ped = new Pedido();
		cl1ped.articulo[0] = comput;
		cl1ped.articulo[1] = mouse;
		
		
		//COMPRA CLIENTE A TIENDA
		Transaccion compra1 = new Venta();
		if (compra1 instanceof Venta) {
			((Venta) compra1).setTienda(tienda1); ((Venta) compra1).setCliente(cl1);
		}
		cl1.realizarPedido(cl1ped, tienda1);
		
		
	}

}