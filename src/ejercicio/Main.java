package ejercicio;

import java.util.Scanner;

public class Main {
	public static final int maxVec = 10;
	public static final int maxTransac = 50;
	
	public static final String fechaHoy = "24/05/2024";

	public static int menu(Scanner scan) {
		System.out.println("Bienvenido al sistema de compra y venta\n\n"
							+ "1) Menu de Tienda\n"
							+ "2) Menu de Cliente\n"
							+ "0) Salir\n\n"
							+ "Opcion: ");
		int op = elegirOpcion(2, 0, scan);
		return op;
	}
	
	public static int menuCliente(Scanner scan) {
		System.out.println("Bienvenido al menu de cliente\n\n"
							+ "1) Comprar articulo\n"
							+ "0) Salir\n\n"
							+ "Opcion: ");
		int op = elegirOpcion(1, 0, scan);
		return op;
	}
	
	public static int menuTienda(Scanner scan) {
		System.out.println("Bienvenido al menu gestor de tiendas\n\n"
							+ "1) Generar pedido a proveedores\n"
							+ "0) Volver\n\n"
							+ "Opcion: ");
		int op = elegirOpcion(1, 0, scan);
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
		
		//ARRAYS
		Cliente clientes[] = new Cliente[maxVec];
		Articulo inventario[] = new Articulo[maxVec];
		Pedido pedidosClientes[] = new Pedido[maxVec];
		Pedido pedidosTienda[] = new Pedido[maxVec];
		Transaccion transacciones[] = new Transaccion[maxVec];
		
		// ARTICULOS DE LA TIENDA
		Articulo comput = new Computadora("RYZEN 3600, RTX 5500, 12 GB RAM", "AMD", 2324, "Computadora", 1200000);
		Articulo mouse = new Periferico("Mouse", "Logitech", 1233, "Logitech g-pro hero", 70000);
		// TIENDA
		Tienda tienda = new Tienda(1, inventario, pedidosClientes, transacciones, "PassioShop", "20-42324345-4");
		tienda.agregarArticulo(mouse);
		tienda.agregarArticulo(comput);
		for (Articulo i : tienda.getInventario()) {
			if (i!=null) {
				System.out.println(i.getNombre());
			}
			
		}
		//PROVEEDOR
		Proveedor prov1 = new Proveedor("Pepe", "2252488458", pedidosTienda, "Distribuidora Pepe", "20-43820449-1");
		
		// CLIENTE
		Cliente cl1 = new Cliente("Dario", "Debesa", 45465012);
		Cliente cl2 = new Cliente("Agustin", "Passiotti", 43820449);
		Cliente cl3 = new Cliente("Lionel", "Messi", 33016244);
		clientes[0]=cl1;
		clientes[1]=cl2;
		clientes[2]=cl3;
		
		// PEDIDO DE CLIENTES
		Articulo art[] = new Articulo[maxVec];
		art[1] = mouse;
		art[2] = comput;
		
		int opc = 1;
		Scanner scan = new Scanner(System.in);
		while (opc!=0) {
			
			opc = menu(scan);
			
			switch(opc) {
				case 1:
					int opctienda=0;
					opctienda = menuTienda(scan);
					switch(opctienda) {
						case 1:
							//genera pedido de proveedores
							Pedido pedT1 = new Pedido(125, art, 1, "23/5/2024");
							//Transaccion transac1 = new Venta();
							tienda.agregarPedido(pedT1);
							cl1.realizarPedido(tienda.getPedidosClientes(), tienda);
							prov1.setPedidostienda(pedidosTienda);
							//transac1 = prov1.despacharPedidos(prov1.getPedidostienda());
							//tienda.transacciones[0]=transac1;
							//Compra compra1 = new Compra(tienda, prov1, tienda.transacciones[0].getId(), tienda.transacciones[0].getPedido(), tienda.transacciones[0].getEstado(), tienda.transacciones[0].getFechaPago(), tienda.transacciones[0].getMontoTotal());
							//System.out.println(compra1.toString());
							break;
					}
					break;
				case 2:
					int opccte=0;
					opccte = menuCliente(scan);
					switch(opccte) {
					case 1:
						//elegir cliente
						Cliente c = new Cliente();
						c = clientes[0];
						Pedido pedC11 = new Pedido(125, art, 1, "23/5/2024");
						Pedido pedC12 = new Pedido(125, art, 1, "23/5/2024");
						Transaccion transac2 = new Transaccion();
						pedidosClientes[0]=pedC11;
						pedidosClientes[1]=pedC12;
						pedidosClientes[0].actualizarCotizacion();
						pedidosClientes[1].actualizarCotizacion();
						c.realizarPedido(pedidosClientes, tienda);
						//prov1.setPedidostienda(pedidosTienda);
						transac2 = tienda.despacharPedidos(tienda.getPedidosClientes());
						tienda.transacciones[1]=transac2;
						Venta venta1 = new Venta(tienda, c, tienda.transacciones[1].getId(), tienda.transacciones[1].getPedido(), tienda.transacciones[1].getEstado(), tienda.transacciones[1].getFechaPago(), tienda.transacciones[1].getMontoTotal());
						System.out.println(venta1.toString());
						break;
				}
					break;
				default:
				
				  break;
			}
			
		}
		scan.close();
	}

}