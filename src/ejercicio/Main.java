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
		int opc = 1;
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
	}
	
	
}
