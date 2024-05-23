package ejercicio;

public class Componente extends Articulo{
	private String marca;
	public Componente() {
		this.marca="";
	}
	public Componente(String marca) {
		this.marca=marca;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
