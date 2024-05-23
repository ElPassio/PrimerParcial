package ejercicio;

public class Computadora extends Componente{
	private String especificaciones;
	public Computadora() {
		this.especificaciones="";
	}
	public Computadora(String especificaciones) {
		this.especificaciones=especificaciones;
	}
	public String getEspecificaciones() {
		return especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
	
}
