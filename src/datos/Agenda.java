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
import java.util.Collections;
import java.util.Comparator;
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
		Comparator<Contacto> comparador = new Comparator<Contacto>(){

			@Override
			public int compare(Contacto o1, Contacto o2) {
				// TODO Auto-generated method stub
				return o1.getNombre().compareTo(o2.getNombre());
			}
			
		};
		if(contacto.getNombre().isEmpty() || contacto.getNombre().isBlank()) {
			return false;
		}
		contactos.add(contacto);
		Collections.sort(contactos, comparador );
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
	
	
	
	
	public int buscarContacto( String nombreContacto)
	{
		for(int i = 0; i < contactos.size();i++) {
			if(nombreContacto.equals(contactos.get(i).getNombre())){
				return i;
			}
		}
		return -1;
	}
	
	//implementar este mï¿½todo y sobrecargarlo con varios parï¿½metros(dependiendo de quï¿½ atributo contacto se quiera editar)
	//implementarlo tambiï¿½n en vez del parï¿½metro contacto con el indice de la lista
	public void editarContacto(int index, String nombre, String apellido, String email,String direccion, String ciudad, String telefono)
	{
			contactos.set(index, new Contacto(nombre,apellido,email,direccion,ciudad,telefono));
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
            return new ArrayList<Contacto>();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Contacto>();
        } 
		catch(Exception e) {
			 return new ArrayList<Contacto>();
		}
	}

	
	

}
