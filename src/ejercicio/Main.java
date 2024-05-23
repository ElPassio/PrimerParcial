package ejercicio;
import java.util.Scanner;

public class Main {
	public static final int maxVec = 10;
	
	public static int menu(Scanner scan) {
		System.out.println("Bienvenido al sistema de Emergencias\n\n"
							+ "1) A\n"
							+ "2) B\n"
							+ "3) C\n"
							+ "0) Salir\n\n"
							+ "Opcion: ");
		int op = elegirOpcion(4, 0, scan);
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
		// TIENDA
		Articulo inventario[] = new Articulo[maxVec];
		Pedido pedidosClientes[] = new Pedido[maxVec];
		Transaccion transacciones[] = new Transaccion[maxVec];
		Empresa tienda = new Tienda(1, inventario, pedidosClientes, transacciones, "PassioShop", "20-42324345-4");
		// ARTICULOS DE LA TIENDA
		Articulo comput = new Computadora("RYZEN 3600, RTX 5500, 12 GB RAM", "AMD", 2324, "Computadora", 3500);
		
		// CLIENTE
		Cliente cl1 = new Cliente("Dario", "Debesa", 45465012);
		// PEDIDO DEL CLIENTE
		Articulo artcl1[] = new Articulo[1];
		artcl1[0] = comput;
		Pedido pedcl1 = new Pedido(125, artcl1, artcl1[0].getPrecio(), "23/5/2024");
		// TRANSACCION
		Transaccion transac1 = new Transaccion(12, pedcl1, "", "23/5/2024", pedcl1.getCotizacionTotal());
		// VENTA
		Venta venta1 = new Venta(tienda, cl1, 1, pedcl1, "", "23/5/2024", transac1.getMontoTotal());
		
		
		/*int opc = 1;
		Scanner scan = new Scanner(System.in);
		while (opc!=0) {
			
			opc = menu(scan);
			
			switch(opc) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				default:
				
				  break;
			}
			
		}
		scan.close();
		*/
	}
	
	
}
