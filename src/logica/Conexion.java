package logica;

import datos.Agenda;
import datos.Contacto;
import ui.UI;

public class Conexion {
	
	Agenda agenda;
	UI interfaz;
	
	public Conexion()
	{
		agenda = new Agenda();
		Contacto contactoPrueba = new Contacto("Jorge","Hernandez","jhernandezga@unal.edu.co",
								"CRA ashd","Bogota","3122610238");
		agenda.a�adirContacto(contactoPrueba);
		interfaz = new UI();
		interfaz.setVisible(true);
		interfaz.agregar(agenda.getDatosContactos());
	}
	
	//Esta Clase se encargar�a de guardar el objeto agenda serializado(Crear un m�todo o crear otra clase)
	//cada vez que se agregue, borre o edite un contacto hay que serializar
	//falta buscar l�gica de conexi�n entre interfaz y los datos guardados(en el momento de buscar, agregar, editar)
	
	

}
