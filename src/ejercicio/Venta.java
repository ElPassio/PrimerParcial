package ejercicio;

public class Venta extends Transaccion{
	private Tienda tienda;
	private Cliente cliente;
	
	public Venta() {
		super();
		tienda = new Tienda(); cliente = new Cliente();
	}
	public Venta(Tienda tienda, Cliente cliente, int id, Pedido pedido, String estado, String fechaPago, double montoTotal) {
		super(id, pedido, estado, fechaPago, montoTotal);
		this.cliente = cliente; this.tienda = tienda;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String toString() {
		return "Tienda: "+tienda.getNombre()+"\n"+"Clienter: "+cliente.getNombre()+"\n"+" ID de la transaccion: "+super.getId()+"\n"+" Pedido: "+super.getPedido()+"\n"+" Estado: "+super.getEstado()+"\n"+" Fecha de pago: "+super.getFechaPago()+"\n"+" Monto total: "+super.getMontoTotal()+"\n";
	}
}
