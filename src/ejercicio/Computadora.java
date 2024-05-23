package ejercicio;

public class Computadora extends Componente{
	private String especificaciones;
	public Computadora() {
		this.especificaciones="";
	}
	public Computadora(String especificaciones,String marca,  int id, String nombre, double precio) {
		super(marca, id, nombre, precio);
		this.especificaciones=especificaciones;
	}
	public String getEspecificaciones() {
		return especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
	
}
