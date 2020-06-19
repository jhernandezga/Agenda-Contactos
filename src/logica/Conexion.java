package logica;


import datos.Agenda;
import datos.Contacto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


import ui.UI;

public class Conexion {
	
	private static Agenda agenda;
	private static UI interfaz;  
	
	public Conexion()
	{
		agenda = new Agenda();
		interfaz = new UI();
		interfaz.setVisible(true);
		
		//Contacto nn = new Contacto("ssds","asas","asda","sada","asda","ada");
		//agenda.añadirContacto(nn);
		//Guardar();
		interfaz.agregar(agenda.getDatosContactos());
	}
	
        
    public static void Guardar()
    {
    	agenda.serializarContactos();
    		 
     }
         
         
   public static boolean conexionAgregar(String nombre, String apellido, String email,String direccion, String ciudad, String telefono)
  {
	   if(agenda.añadirContacto(new Contacto(nombre,apellido,email, direccion,ciudad,telefono)))
      {
    	  Guardar();
    	  interfaz.agregar(agenda.getDatosContactos());
          return true;
      }
       else{
    	   return false;
       }
        		
   }
   public static void conexionEliminar(int index) {
	  
		   agenda.eliminarContacto(index);
		   interfaz.agregar(agenda.getDatosContactos());
		   Guardar();
   }
   public static void conexionEditar(int index ,Vector<String> fila ) {
	   agenda.editarContacto(index, fila.get(1), fila.get(2), fila.get(3), fila.get(5), fila.get(5), fila.get(6));
	   Guardar();
   }
   
   public static int conexionBuscar(String nombre) {
	   int indexContacto = agenda.buscarContacto(nombre);
	   if(indexContacto == -1) {
		   return -1;
	   }
	   
	   return indexContacto;
	   
   }
         
       
}
