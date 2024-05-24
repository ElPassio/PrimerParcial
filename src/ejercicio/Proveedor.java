package ejercicio;

public class Proveedor extends Empresa implements Facturacion {
	private String nombreContacto;
	private String telefonoContacto;
	private Pedido pedidosTienda[];

	public Proveedor() {
		super();
		this.nombreContacto = "";
		this.telefonoContacto = "";
		this.pedidosTienda = new Pedido[Main.maxVec];
	}

	public Proveedor(String nombreContacto, String telefonoContacto, Pedido[] pedidostienda, String nombre,
			String cuit) {
		super(nombre, cuit);
		this.nombreContacto = nombreContacto;
		this.telefonoContacto = telefonoContacto;
		this.pedidosTienda = pedidostienda;
	}
	public void emitirFactura(Transaccion transaccion) {
		if (transaccion instanceof Compra) {
			for (Articulo a:transaccion.getPedido().getArticulo()) {
				((Compra) transaccion).getTienda().agregarArticulo(a);
			}
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
			//System.out.println(transaccion.ToString(total));
		}
	}
	
	public void despacharPedidos(Pedido pedidosTienda[]) {
		if (pedidosTienda != null) {
			for (Pedido p : pedidosTienda) {
				if (p != null) {
					Transaccion t = new Transaccion(p.getId(), p, "AGREGADO", Main.fechaHoy, p.getCotizacionTotal());
					emitirFactura(t);
				}
			}
		} else {
			System.err.println("No hay pedidos cargados.");
		}
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
		return pedidosTienda;
	}

	public void setPedidostienda(Pedido[] pedidostienda) {
		this.pedidosTienda = pedidostienda;
	}

}
