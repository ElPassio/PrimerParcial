package ejercicio;

public class Tienda extends Empresa implements Facturacion, Comprador {
	private int sucursal;
	public Articulo inventario[];
	public Pedido pedidosClientes[];
	public Transaccion transacciones[];

	public Tienda() {
		super();
		sucursal = 0;
		inventario = new Articulo[Main.maxVec];
		pedidosClientes = new Pedido[Main.maxVec];
		transacciones = new Transaccion[Main.maxVec];

	}

	public Tienda(int sucursal, Articulo[] inventario, Pedido[] pedidosClientes, Transaccion[] transacciones,
			String nombre, String cuit) {
		super(nombre, cuit);
		this.sucursal = sucursal;
		this.inventario = inventario;
		this.pedidosClientes = pedidosClientes;
		this.transacciones = transacciones;
	}

	public void agregarPedido(Pedido pedido) {
		for (int i = 0; i < pedidosClientes.length-1;i++) {
			if (pedidosClientes[i] == null) {
				pedidosClientes[i] = pedido;
				return;
			}
		}
	}
	
	public void agregarArticulo(Articulo articulo) {
		for (int i = 0; i < inventario.length-1;i++) {
			if (inventario[i] == null) {
				inventario[i] = articulo;
				return;
			}
		}
	}

	public boolean eliminar(Articulo articulo) {
		boolean resultado = false;
		for (int i = 0; i < inventario.length; i++) {
			if (inventario[i] == articulo) {
				for (int j = i; j < inventario.length - 1; j++) {
					inventario[j] = inventario[j+1];
				}
				inventario[inventario.length - 1] = null;
				resultado = true;
			}
		}
		return resultado;
	}
	
	public void eliminarArticulo(Articulo articulo) {
		String nombre = articulo.getNombre();
		if (buscarArticulo(articulo.getNombre()) == articulo) {
			if (eliminar(articulo)) {
				System.out.println("Se elimino "+nombre+" del inventario.");
			} else {
				System.err.println("El arreglo sigue intacto.");
			}
		}
	}

	public Articulo buscarArticulo(String nombre) {
		for (Articulo i : inventario) {
			if (i!=null) {
				if (i.getNombre() == nombre) {
					return i;
				}
			}
		}
		System.out.println("No se encontro el articulo.");
		return null;
	}

	public void realizarPedido(Pedido pedido[], Empresa empresa) {
		if (empresa instanceof Proveedor) {
			if (pedido != null) {
					((Proveedor)empresa).despacharPedidos(pedido);
			}
		}
	}

	public double emitirFactura(Transaccion transaccion) {
		if (transaccion instanceof Venta) {
			for (Articulo a : transaccion.getPedido().getArticulo()) {
				if (buscarArticulo(a.getNombre())==a) {
					eliminarArticulo(buscarArticulo(a.getNombre()));
				}
			}
		}
		return transaccion.getMontoTotal();
	}
	
	public void agregarTransaccion(Transaccion t) {
		for (Transaccion aux : transacciones) {
			if (aux == null) {
				aux = t;
				return;
			}
		}
	}
	
	public Transaccion despacharPedidos(Pedido pedidos[]) {
		Transaccion t = new Venta();
		if (pedidos != null) {
			for (Pedido p : pedidos) {
				if (p != null) {
					for (Articulo a : p.getArticulo()) {
						if (a!=null) {
							if ((buscarArticulo(a.getNombre())) == a) {
								// DESPACHAR PEDIDO si TRUE
								t = new Transaccion(p.getId(), p, "DESPACHADO", Main.fechaHoy, p.getCotizacionTotal());
								emitirFactura(t);
								agregarTransaccion(t);
							} else {
								System.err.println("\nEl articulo no esta en el inventario.");
								t = new Transaccion(p.getId(), p, "CANCELADO", Main.fechaHoy, p.getCotizacionTotal());
								agregarTransaccion(t);
							}
						}
					}
				}
			}
		} else {
			System.err.println("No hay pedidos cargados.");
		}
		return t;
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
