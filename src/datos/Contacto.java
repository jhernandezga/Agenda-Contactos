package datos;

import java.io.Serializable;

public class Contacto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -532975367196361435L;
	private String nombre;
	private String apellido;
	private  String email;
	private String direccion;
	private String ciudad;
	private String telefono;
	public static final int NUMERO_ATRIBUTOS = 6;
	
	
	
	public Contacto(String nombre, String apellido, String email, String direccion, String ciudad, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
	}
	public Contacto()
	{
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
