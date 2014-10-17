package delegados;

import java.util.*;

/**
 *
 * @author https://github.com/arkadoel
 */
public interface PersonaEventListener extends EventListener {
	void NombreCambiado (PersonaEventObject args);
	void EdadCambiado (PersonaEventObject args);

}
