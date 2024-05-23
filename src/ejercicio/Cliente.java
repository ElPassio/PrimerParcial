package ejercicio;

public class Cliente implements Comprador{
	private String nombre;
	private String apellido;
	private int documento;
	public Cliente() {
		this.nombre = "";
		this.apellido = "";
		this.documento = 0;
	}
	public Cliente(String nombre, String apellido, int documento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public void realizarPedido(Pedido pedido, Empresa tienda) {
		
	}
}
