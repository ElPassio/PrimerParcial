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
		double total = transaccion.getMontoTotal();
		if(total<100000){
			transaccion.setMontoTotal((total*5)/100);
		}else if(total>100000 && total<600000) {
			transaccion.setMontoTotal((total*10)/100);
		}else if(total>600000 && total<1200000) {
			transaccion.setMontoTotal((total*20)/100);
		}else if(total>1200000) {
			transaccion.setMontoTotal((total*30)/100);
		}
		System.out.println(transaccion.ToString(total));
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
