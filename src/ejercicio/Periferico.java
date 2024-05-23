package ejercicio;

public class Periferico extends Componente {
	private String tipo;
	public Periferico() {
	this.tipo = "";	
	}
	public Periferico(String tipo, String marca, int id, String nombre, double precio) {
		super(marca, id, nombre, precio);
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
