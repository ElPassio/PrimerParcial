package ejercicio;

public class Proveedor extends Empresa implements Facturacion {
	private String nombreContacto;
	private String telefonoContacto;
	private Pedido pedidostienda[];

	public Proveedor() {
		super();
		this.nombreContacto = "";
		this.telefonoContacto = "";
		this.pedidostienda = new Pedido[Main.maxVec];
	}

	public Proveedor(String nombreContacto, String telefonoContacto, Pedido[] pedidostienda, String nombre,
			String cuit) {
		super(nombre, cuit);
		this.nombreContacto = nombreContacto;
		this.telefonoContacto = telefonoContacto;
		this.pedidostienda = pedidostienda;
	}
	public void emitirFactura(Transaccion transaccion) {
		if(transaccion.getMontoTotal()){}
	}
	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public Pedido[] getPedidostienda() {
		return pedidostienda;
	}

	public void setPedidostienda(Pedido[] pedidostienda) {
		this.pedidostienda = pedidostienda;
	}

	public void despacharPedidos() {

	}
}
