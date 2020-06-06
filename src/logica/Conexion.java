package logica;


import datos.Agenda;
import datos.Contacto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.UI;

public class Conexion implements Serializable {
	
	private static Agenda agenda;
	private UI interfaz;
        
        
	
	public Conexion()
	{
		agenda = new Agenda();
		interfaz = new UI();
		interfaz.setVisible(true);
		interfaz.agregar(Leer().getDatosContactos());
	}
	
	//Esta Clase se encargar�a de guardar el objeto agenda serializado(Crear un m�todo o crear otra clase)
	//cada vez que se agregue, borre o edite un contacto hay que serializar
	//falta buscar l�gica de conexi�n entre interfaz y los datos guardados(en el momento de buscar, agregar, editar)
	
        
    public static void Guardar()
    {
             FileOutputStream fileStrem = null;
             try {
                 // If the file "MySaveFile.obj" does not exist, it will be created
            // FileOutputStrem knows how to connect (and create) a file
            fileStrem = new FileOutputStream("MySaveFile.obj");           

            // ObjectOutputStream let us write objects
            ObjectOutputStream os = new ObjectOutputStream(fileStrem);

            // Serialize and write the object to file
            os.writeObject(agenda);

            // Close the stream 
            os.close();

//            System.out.println(agenda);
             } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileStrem.close();
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
         }

        }
         
         
         public Agenda Leer()
         {
             FileInputStream fileStremin = null;

        try {
            // If the file "MySaveFile.obj" does not exist, an exception will be thrown
            fileStremin = new FileInputStream("MySaveFile.obj");

            // ObjectOutputStream let us load objects
            ObjectInputStream os = new ObjectInputStream(fileStremin);

            // Load first two object from the file
            Object firstAgenda = os.readObject();

            // Cast from objects to Person
            Agenda pragenda = (Agenda) firstAgenda;
            return pragenda;

//            System.out.println(pragenda);

            // ..
         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                fileStremin.close();
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
         }
}
