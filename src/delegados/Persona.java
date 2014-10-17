package delegados;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author https://github.com/arkadoel
 */
public class Persona implements PersonaEventListener {

	private String id;
	private String nombre;
	private int edad;
	
	// Aqui se almacenaran todos los manejadores (delegados) de evento
	private ArrayList listeners;
	
	public Persona (String id, String nombre, int edad)
	{
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		// Creamos el almacen de los listeners. ArrayList almacena objetos, por tanto para recuperarlos tendremos que hacer CASTINGS
		listeners = new ArrayList ();
		// La clase persona tambien es un PersonaEventListener, entonces lo agregamos
		// para crear los eventos predeterminados (mas abajo codificados)
		listeners.add(this);
	}
	
	public void addPersonaEventListener (PersonaEventListener listener)
	{
		// agregamos el manejador a nuestra lista
		listeners.add(listener);
	}
	
	public void setNombre (String newNombre)
	{
		// Cambiamos el nombre de la persona en el objeto actual
		nombre = newNombre;
		
		ListIterator li = listeners.listIterator();
		// Recorremos la lista para ejecutar el metodo NombreCambiado de cada manejador almacenado
		while (li.hasNext()) {
			// Convertimos (CAST) de nuestro objeto 
			PersonaEventListener listener = (PersonaEventListener)li.next();
			
			// Creamos el objeto que tiene la información del evento
			PersonaEventObject personaEvObj = new PersonaEventObject (this, // source (Object) 
					this // InformacionExtra (Persona)
				);
			// Ejecutamos el metodo manejador del evento con los parametros necesarios
			(listener).NombreCambiado(personaEvObj);
		}
		
	}
	
	// Este metodo hace los mismo que setNombre pero sobre la propiedad edad
	// en menos lineas.
	public void setEdad (int newEdad)
	{
		edad = newEdad;
		
		ListIterator li = listeners.listIterator();
		while (li.hasNext()) {
			((PersonaEventListener)li.next()).EdadCambiado(new PersonaEventObject (this, this));
		}
	}
	
	public String getId ()
	{
		return id;
	}
	
	public String getNombre ()
	{
		return nombre;
	}
	
	public int getEdad ()
	{
		return edad;
	}
	
	//@override
	public String toString ()
	{
		return String.format("[Id:%s,Nombre:%s,Edad:%d]", id, nombre, edad);
	}
	
	// Manejadores predeterminados: implementación de la interface PersonaEventListener
	public void NombreCambiado (PersonaEventObject args)
	{	
		System.out.println(String.format("Default:%s:NombreCambiado:%s", 
				"", args.getPersona()));
	}
	
	public void EdadCambiado (PersonaEventObject args)
	{
		System.out.println(String.format("Default:%s:EdadCambiado:%s", 
				"", args.getPersona()));
	}
}
