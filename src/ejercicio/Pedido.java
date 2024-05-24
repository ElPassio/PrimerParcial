package ejercicio;

public class Pedido {
	private int id;
	protected Articulo[] articulo;
	private double cotizacionTotal;
	private String fechaCotizacion;

	public Pedido() {
		id = 0;
		articulo = new Articulo[Main.maxVec];
		cotizacionTotal = 0;
		fechaCotizacion = "";
	}

	public Pedido(int id, Articulo[] articulo, double cotizacionTotal, String fechaCotizacion) {
		this.id = id;
		this.articulo = articulo;
		this.cotizacionTotal = cotizacionTotal;
		this.fechaCotizacion = fechaCotizacion;
	}

	public void actualizarCotizacion() { // ACTUALIZA COTIZACIONTOTAL AL INGRESAR EL PEDIDO
		if (articulo != null) {
			for (Articulo a : articulo) {
				if (a != null) {
					cotizacionTotal += a.getPrecio();
				}
			}
		} else {
			System.err.println("\nEl pedido no tiene articulos.");
		}
	}

	public void mostrarArticulos(Articulo[] lista) {
		for (Articulo a : lista) {
			System.out.println(a + "\n");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Articulo[] getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo[] articulo) {
		this.articulo = articulo;
	}

	public double getCotizacionTotal() {
		return cotizacionTotal;
	}

	public void setCotizacionTotal(double cotizacionTotal) {
		this.cotizacionTotal = cotizacionTotal;
	}

	public String getFechaCotizacion() {
		return fechaCotizacion;
	}

	public void setFechaCotizacion(String fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n	ID: ").append(id).append("\n");
		sb.append("	Articulos: \n");

		for (int i = 0; i < articulo.length; i++) {
			if(articulo[i]!=null) {
				sb.append("	  ").append(articulo[i].toString()).append("\n");
			}
		}
		sb.append(" Cotizacion total:" + cotizacionTotal + "\n");
		sb.append(" Fecha Cotizacion:" + fechaCotizacion + "\n");

		return sb.toString();
	}
}
