package ejercicio;

import java.util.Scanner;

public class Main {
	public static final int maxVec = 10;
	public static final String fechaHoy = "24/05/2024";

	public static int menu(Scanner scan) {
		System.out.println("Bienvenido al sistema de Emergencias\n\n"
							+ "1) Gestion de Tiendas\n"
							+ "2) Gestion de Proveedores\n"
							+ "3) Gestion de Clientes\n"
							+ "0) Salir\n\n"
							+ "Opcion: ");
		int op = elegirOpcion(3, 0, scan);
		return op;
	}
	
	public static int menuProveedores(Scanner scan) {
		System.out.println("Bienvenido al menu gestor de proveedores\n\n"
							+ "1) Cargar nuevo proveedor\n"
							+ "2) Ingresar articulo al inventario de proveedor\n"
							+ "3) Emitir factura"
							+ "0) Salir\n\n"
							+ "Opcion: ");
		int op = elegirOpcion(2, 0, scan);
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
		Articulo inventario[] = new Articulo[maxVec];
		Pedido pedidosClientes[] = new Pedido[maxVec];
		Pedido pedidosTienda[] = new Pedido[maxVec];
		Transaccion transacciones[] = new Transaccion[maxVec];
		Articulo art[] = new Articulo[maxVec];
		
		// ARTICULOS DE LA TIENDA
		Articulo comput = new Computadora("RYZEN 3600, RTX 5500, 12 GB RAM", "AMD", 2324, "Computadora", 1200000);
		Articulo mouse = new Periferico("Mouse", "Logitech", 1233, "Logitech g-pro hero", 70000);
		art[0] = comput;
		art[1] = mouse;
		
		// TIENDA
		Tienda tienda = new Tienda(1, inventario, pedidosClientes, transacciones, "PassioShop", "20-42324345-4");

		//PROVEEDOR
		Proveedor prov1 = new Proveedor("Pepe", "2252488458", pedidosTienda, "Distribuidora Pepe", "20-43820449-1");
		// CLIENTE
		Cliente cl1 = new Cliente("Dario", "Debesa", 45465012);
		
		// PEDIDOS
			//PEDIDOS DEL CLIENTE A TIENDA
			Pedido pedC1 = new Pedido(125, art, 1, "23/5/2024");
			pedidosClientes[0]=pedC1;
		
			//PEDIDOS DE TIENDA A PROVEEDOR
			
		
		// VENTA
		//Venta venta1 = new Venta(tienda, cl1, 1, pedT1, "", "23/5/2024", transac1.getMontoTotal());

		//COMPRA
		
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
							pedidosTienda[0]=pedT1;
							Transaccion transac1 = new Transaccion(12, pedT1, "", "23/5/2024", pedT1.getCotizacionTotal());
							tienda.agregarArticulo(art[0]);
							tienda.agregarArticulo(art[1]);
							tienda.realizarPedido(pedidosTienda, tienda);
							//prov1.despacharPedidos(pedidosTienda);
							Compra compra1 = new Compra(tienda, prov1, transac1.getId(), transac1.getPedido(), transac1.getEstado(), transac1.getFechaPago(), transac1.getMontoTotal());
							System.out.println(compra1.toString());
							break;
						case 2:
							
							break;
					}
					break;
				case 2:
					int opcprov=0;
					opcprov = menuProveedores(scan);
					//gestion de proveedores
					switch(opcprov) {
					case 1:
						//crea nuevo proveedor
						tienda = new Tienda(1, inventario, pedidosClientes, transacciones, "PassioShop", "20-42324345-4");
						break;
					case 2:
						//busca la tienda entre las que hay con el mismo nombre
						Tienda buscaT = new Tienda();
						buscaT.setNombre("PassioShop");
					
							//compara si es igual el que esta en array al ingresado
							if(tienda.getNombre().equals(buscaT.getNombre())) {
								//ingresa un nuevo articulo al inventario de la tienda seleccionada
									tienda.getInventario()[0] = art[0];
							}
						
						break;
				}
					break;
				case 3:
					
					break;
				default:
				
				  break;
			}
			
		}
		scan.close();
	}

}