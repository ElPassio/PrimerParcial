package ejercicio;

public class Tienda implements Facturacion extends Empresa{
	private int sucursal;
	public Articulo inventario[];
	public Pedido pedidosClientes[];
	public Transaccion transacciones[];
	public Tienda(int sucursal, Articulo[] inventario, Pedido[] pedidosClientes, Transaccion[] transacciones, String nombre, String cuit) {
		super(nombre, cuit);
		this.sucursal = sucursal;
		this.inventario = inventario;
		this.pedidosClientes = pedidosClientes;
		this.transacciones = transacciones;
	}
	
}
