package ejercicio;

public class Tienda extends Empresa implements Facturacion{
	private int sucursal;
	public Articulo inventario[];
	public Pedido pedidosClientes[];
	public Transaccion transacciones[];
	
	public Tienda() {
		super();
		sucursal = 0; inventario = new Articulo[Main.maxVec];
		pedidosClientes = new Pedido[Main.maxVec];
		transacciones = new Transaccion[Main.maxVec]; // quizas reemplazar maxVec
		
	}
	
	public Tienda(int sucursal, Articulo[] inventario, Pedido[] pedidosClientes, Transaccion[] transacciones, String nombre, String cuit) {
		super(nombre, cuit);
		this.sucursal = sucursal;
		this.inventario = inventario;
		this.pedidosClientes = pedidosClientes;
		this.transacciones = transacciones;
	}
	public void realizarPedido(Pedido pedido, Empresa empresa) {
		
	}
	
	public void emitirFactura(Transaccion transaccion) {
		
	}
}
