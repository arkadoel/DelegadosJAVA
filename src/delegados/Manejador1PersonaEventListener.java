
package delegados;

/**
 *
 * @author https://github.com/arkadoel
 */
public class Manejador1PersonaEventListener implements PersonaEventListener {

	public void NombreCambiado (PersonaEventObject args)
	{
		System.out.println (String.format ("%s:NombreCambiado:%s", args.getPersona().getId (), args.getPersona().getNombre ()));
	}
	
	public void EdadCambiado (PersonaEventObject args)
	{
		System.out.println (String.format ("%s:EdadCambiado:%s", args.getPersona().getId (), args.getPersona().getEdad ()));		
	}

}
