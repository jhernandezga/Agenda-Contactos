package datos;

import java.util.ArrayList;

public class Agenda {
	ArrayList<Contacto> contactos;
	
	public Agenda()
	{
		contactos = new ArrayList<Contacto>();
	}
	
	//implementar Estos métodos
	
	public ArrayList<Contacto> getContactos()
	{
		return contactos;
	}
	
	public String[][] getDatosContactos(){
		String [][] datos = new String[getContactos().size()+2][Contacto.NUMERO_ATRIBUTOS];
		Contacto tmp;
		for(int i = 0; i < getContactos().size(); i++)
		{
			tmp = getContactos().get(i);
			String[]  temporal = {""+(contactos.size())+"",tmp.getNombre(),tmp.getApellido(),tmp.getEmail(),tmp.getDireccion(),
						tmp.getCiudad(),""+tmp.getTelefono()+""};
			datos[i] = temporal;
			}
		return datos;
			
	}
	
	
	//crear estos metodos también sobre cargados con la parametros de nombre, apellido,etc, oara crear un objeto contacto con esos parametros
	public boolean añadirContacto(Contacto contacto)
	{
		contactos.add(contacto);
		return true;
	}
	
	public boolean eliminarContacto(Contacto contacto)
	{
		return true;
	}
	
	public boolean eliminarContacto(int indiceContacto)
	{
		return true;
	}
	
	
	
	
	public Contacto buscarContacto(String nombreContacto)
	{
		return new Contacto();
	}
	
	//implementar este método y sobrecargarlo con varios parámetros(dependiendo de qué atributo contacto se quiera editar)
	//implementarlo también en vez del parámetro contacto con el indice de la lista
	public void editarContacto(Contacto contacto)
	{
			
	}
	
	

}
