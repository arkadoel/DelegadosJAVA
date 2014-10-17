package delegados;
import java.util.EventListener;
import java.util.EventObject;
/**
 * Ejemplo de uso de delegados en JAVA
 * @date 17-Oct-2014  22:44 
 * @author https://github.com/arkadoel
 */
public class Delegados {

    public static void main(String[] args){
    	Persona p = new Persona ("Persona1", "Juan Fu", 10);
    	p.addPersonaEventListener(new Manejador1PersonaEventListener ());
    	
    	
    	p.setNombre("Paco Fu");
    	p.setEdad(20);
    	
    }
    
}
