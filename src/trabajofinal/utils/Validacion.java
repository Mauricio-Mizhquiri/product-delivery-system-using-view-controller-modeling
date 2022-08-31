
package trabajofinal.utils;

public class Validacion {
    
    public static boolean esPlaca(String s) {
        return s.matches("[a-zA-Z]{3}-[0-9]{3}");
    }
    
}
