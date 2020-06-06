package datos;

import java.io.Serializable;
import java.util.ArrayList;

public class Agenda implements Serializable {
	ArrayList<Contacto> contactos;
	
	public Agenda()
	{
		contactos = new ArrayList<Contacto>();
	}
	
	//implementar Estos metodos
	
	public ArrayList<Contacto> getContactos()
	{
		return contactos;
	}
	
	public String[][] getDatosContactos(){
		String [][] datos = new String[getContactos().size()][Contacto.NUMERO_ATRIBUTOS];
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
	
	
	//crear estos metodos tambiï¿½n sobre cargados con la parametros de nombre, apellido,etc, oara crear un objeto contacto con esos parametros
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
	
	
	
	
	public Contacto buscarContacto( String nombreContacto)
	{
		return new Contacto();
	}
	
	//implementar este mï¿½todo y sobrecargarlo con varios parï¿½metros(dependiendo de quï¿½ atributo contacto se quiera editar)
	//implementarlo tambiï¿½n en vez del parï¿½metro contacto con el indice de la lista
	public void editarContacto(Contacto contacto)
	{
			
	}
	
	

}
