package ejercicio;

public class Componente extends Articulo{
	private String marca;
	public Componente() {
		super();
		this.marca="";
	}
	public Componente(String marca, int id, String nombre, double precio) {
		super(id, nombre, precio);
		this.marca=marca;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
