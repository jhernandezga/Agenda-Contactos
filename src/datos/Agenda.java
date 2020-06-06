package datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import logica.Conexion;

public class Agenda implements Serializable {
	

	private static final long serialVersionUID = 7673322979056613018L;
	private ArrayList<Contacto> contactos;
	
	public Agenda()
	{
		contactos = deserializarContactos();
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
			String[]  temporal = {""+(i+1)+"",tmp.getNombre(),tmp.getApellido(),tmp.getEmail(),tmp.getDireccion(),
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
		if(contactos.remove(indiceContacto) != null)
		{
			return true;
		}
		else {
			return false;
		}
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
	
	
	
	public void serializarContactos()
	{
		File fichero = new File("MySaveFile.obj");
	    try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fichero))) {
	       
            os.writeObject(contactos);
            os.close();

         } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
	}
	
	
	public ArrayList<Contacto> deserializarContactos() {
		File fichero = new File("MySaveFile.obj");
		try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(fichero))) {

            Object firstLista = os.readObject();
            return (ArrayList<Contacto>) firstLista;
            
         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
	}

	
	

}
