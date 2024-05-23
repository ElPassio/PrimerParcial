package ejercicio;

public class Venta {
	private Tienda tienda;
	private Cliente cliente;
	
	public Venta() {
		tienda = new Tienda(); cliente = new Cliente();
	}
	public Venta(Tienda tienda, Cliente cliente) {
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
}
