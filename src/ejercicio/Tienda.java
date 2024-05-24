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
		transacciones = new Transaccion[Main.maxVec]; // quizas reemplazar maxVec

	}

	public Tienda(int sucursal, Articulo[] inventario, Pedido[] pedidosClientes, Transaccion[] transacciones,
			String nombre, String cuit) {
		super(nombre, cuit);
		this.sucursal = sucursal;
		this.inventario = inventario;
		this.pedidosClientes = pedidosClientes;
		this.transacciones = transacciones;
	}

	public void agregarArticulo(Articulo articulo) {
		for (Articulo i : inventario) {
			if (i == null) {
				i = articulo;
			}
		}
	}

	public void eliminarArticulo(Articulo articulo) {
		Articulo buscaArt = articulo;
		for (int i = 0; i < inventario.length; i++) {
			if (inventario[i].getId() == buscaArt.getId()) {
				inventario[i] = inventario[i + 1];
				inventario[inventario.length] = null;
			}
		}
	}

	public Articulo buscarArticulo(String nombre) {
		Articulo result = new Articulo();
		for (Articulo i : inventario) {
			if (i.getNombre() == nombre) {
				result = i;
			}
		}
		return result;
	}

	public void realizarPedido(Pedido pedido[], Empresa empresa) {
        if (empresa instanceof Proveedor) {
            if (pedido != null) {
                ((Proveedor)empresa).despacharPedidos(pedido);
            }
        }
    }

	public void emitirFactura(Transaccion transaccion) {
		if (transaccion instanceof Venta) {
			for (Articulo a : transaccion.getPedido().getArticulo()) {
				if (buscarArticulo(a.getNombre()) == a) {
					eliminarArticulo(buscarArticulo(a.getNombre()));
				}
			}
		}
	}
	
	public void agregarTransaccion(Transaccion t) {
		for (Transaccion aux : transacciones) {
			if (aux == null) {
				aux = t;
			}
		}
	}
	
	public void despacharPedidos(Pedido pedidos[]) {
		if (pedidos != null) {
			for (Pedido p : pedidos) {
				if (p != null) {
					for (Articulo a : p.getArticulo()) {
						if (buscarArticulo(a.getNombre()) == a) {
							// DESPACHAR PEDIDO si TRUE
							Transaccion t = new Transaccion(p.getId(), p, "DESPACHADO", Main.fechaHoy, p.getCotizacionTotal());
							agregarTransaccion(t);
							emitirFactura(t);
						} else {
							Transaccion t = new Transaccion(p.getId(), p, "CANCELADO", Main.fechaHoy, p.getCotizacionTotal());
							agregarTransaccion(t);
						}
					}
				}
			}
		} else {
			System.err.println("No hay pedidos cargados.");
		}
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
