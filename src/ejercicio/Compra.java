package ejercicio;

public class Compra extends Transaccion {
	private Tienda tienda;
	private Proveedor proveedor;
	
	public Compra() {
		super();
		this.proveedor = new Proveedor(); this.tienda = new Tienda();
	}

	public Compra(Tienda tienda, Proveedor proveedor,int id, Pedido pedido, String estado, String fechaPago, double montoTotal) {
		super(id, pedido, estado, fechaPago, montoTotal);
		this.tienda = tienda;
		this.proveedor = proveedor;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public String toString() {
		return "Tienda: "+tienda.getNombre()+"\n"+"Proveedor: "+proveedor.getNombre()+"\n"+" ID de la transaccion: "+super.getId()+"\n"+" Pedido: "+super.getPedido()+"\n"+" Estado: "+super.getEstado()+"\n"+" Fecha de pago: "+super.getFechaPago()+"\n"+" Monto total: "+super.getMontoTotal()+"\n";
	}
}
