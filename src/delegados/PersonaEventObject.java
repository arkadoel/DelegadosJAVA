package delegados;

import java.util.EventObject;

/**
 *
 * @author https://github.com/arkadoel
 */
public class PersonaEventObject extends EventObject {
	public Persona persona;
	
	public PersonaEventObject (Object source, Persona persona)
	{
		super (source);
		this.persona = persona;
	}
	
	public Persona getPersona ()
	{
		return persona;
	}

}
