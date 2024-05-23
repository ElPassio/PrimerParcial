package ejercicio;

public class Empresa {
	private String nombre;
	private String cuit;
	public Empresa() {
		this.nombre = "";
		this.cuit = "";
	}
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	public void despacharPedidos(Pedido pedidos[]) {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
}

