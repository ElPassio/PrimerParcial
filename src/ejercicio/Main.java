package ejercicio;
import java.util.Scanner;

public class Main {
	public static final int maxVec = 10;
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
	
	public static int menuTienda(Scanner scan) {
		System.out.println("Bienvenido al menu gestor de tiendas\n\n"
							+ "1) Cargar nueva tienda\n"
							+ "2) Ingresar articulo al inventario de tienda existente\n"
							+ "0) Salir\n\n"
							+ "Opcion: ");
		int op = elegirOpcion(2, 0, scan);
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
	
	public static int elegirOpcion(int top, int bot, Scanner scan) {
		int opc = scan.nextInt();
		while (opc < bot || opc > top) {
			opc = scan.nextInt();
			if (opc < bot || opc > top) {
				System.err.println("\nOpcion fuera de rango. Elija un valor entre "+bot+" y "+top+".");
			}
		}
		return opc;
	}
	
	public static void main(String[] args) {
		// ARTICULOS DE LA TIENDA
		
		//proveedores
		Proveedor proveedores[] = new Proveedor[maxVec];
		
		// TIENDA
		Articulo inventario[] = new Articulo[maxVec];
		Pedido pedidosClientes[] = new Pedido[maxVec];
		Transaccion transacciones[] = new Transaccion[maxVec];
		Tienda tienda[] = new Tienda[maxVec];
		Articulo articulos[] = new Articulo[maxVec];
		articulos[0]=new Computadora("RYZEN 3600, RTX 5500, 12 GB RAM", "AMD", 2324, "Computadora", 3500);
		// CLIENTE
		Cliente cl1 = new Cliente("Dario", "Debesa", 45465012);
		// PEDIDO DEL CLIENTE
		Articulo artcl1[] = new Articulo[1];
		artcl1[0] = articulos[0];
		Pedido pedcl1 = new Pedido(125, artcl1, artcl1[0].getPrecio(), "23/5/2024");
		// TRANSACCION
		Transaccion transac1 = new Transaccion(12, pedcl1, "", "23/5/2024", pedcl1.getCotizacionTotal());
		// VENTA
		//Venta venta1 = new Venta(tienda, cl1, 1, pedcl1, "", "23/5/2024", transac1.getMontoTotal());
		//tienda.agregarArticulo(comput, cantart);
		
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
							//llena inventario nueva tienda
							tienda[0].inventario[0] = articulos[0];
							tienda[0].inventario[1] = articulos[0];
							//crea nueva tienda con inventario cargado
							tienda[0] = new Tienda(1, inventario, pedidosClientes, transacciones, "PassioShop", "20-42324345-4");
							break;
						case 2:
							//busca la tienda entre las que hay con el mismo nombre
							Tienda buscaT = new Tienda();
							buscaT.setNombre("PassioShop");
							for(int i=0; i<tienda.length; i++){
								//compara si es igual el que esta en array al ingresado
								if(tienda[i].getNombre().equals(buscaT.getNombre())) {
									//ingresa un nuevo articulo al inventario de la tienda seleccionada
										tienda[i].getInventario()[0] = articulos[0];
								}
							}
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
						tienda[0] = new Tienda(1, inventario, pedidosClientes, transacciones, "PassioShop", "20-42324345-4");
						break;
					case 2:
						//busca la tienda entre las que hay con el mismo nombre
						Tienda buscaT = new Tienda();
						buscaT.setNombre("PassioShop");
						for(int i=0; i<tienda.length; i++){
							//compara si es igual el que esta en array al ingresado
							if(tienda[i].getNombre().equals(buscaT.getNombre())) {
								//ingresa un nuevo articulo al inventario de la tienda seleccionada
									tienda[i].getInventario()[0] = articulos[0];
							}
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
