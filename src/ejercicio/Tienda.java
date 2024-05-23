package ejercicio;

public class Tienda extends Empresa implements Facturacion, Comprador{
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
	
	public void agregarArticulo(Articulo articulo) {
		
	}
	
	public void eliminarArticulo(Articulo articulo) {
		
	}
	
	public Articulo buscarArticulo(String nombre, Articulo inventario) {
		return inventario;
	}
	
	public void realizarPedido(Pedido pedido, Empresa empresa) {
		
	}
	
	public void emitirFactura(Transaccion transaccion) {
		
	}

	public int getSucursal() {
		return sucursal;
	}

	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}

	public Articulo[] getInventario() {
		return inventario;
	}

	public void setInventario(Articulo[] inventario) {
		this.inventario = inventario;
	}

	public Pedido[] getPedidosClientes() {
		return pedidosClientes;
	}

	public void setPedidosClientes(Pedido[] pedidosClientes) {
		this.pedidosClientes = pedidosClientes;
	}

	public Transaccion[] getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Transaccion[] transacciones) {
		this.transacciones = transacciones;
	}
}
