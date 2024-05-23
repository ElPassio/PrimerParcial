package ejercicio;

public class Compra {
	private Tienda tienda;
	private Proveedor proveedor;
	
	public Compra() {
		this.proveedor = new Proveedor(); this.tienda = new Tienda();
	}

	public Compra(Tienda tienda, Proveedor proveedor) {
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
}
