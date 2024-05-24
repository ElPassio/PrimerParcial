package ejercicio;

public class Pedido {
	private int id;
	private Articulo[] articulo;
	private double cotizacionTotal;
	private String fechaCotizacion;
	
	public Pedido() {
		id = 0;
		articulo = new Articulo[Main.maxVec];
		cotizacionTotal = 0; fechaCotizacion = "";
	}

	public Pedido(int id, Articulo[] articulo, double cotizacionTotal, String fechaCotizacion) {
		this.id = id;
		this.articulo = articulo;
		this.cotizacionTotal = cotizacionTotal;
		this.fechaCotizacion = fechaCotizacion;
	}

	public void actualizarCotizacion() {
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
}
