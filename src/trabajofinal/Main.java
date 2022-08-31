
package trabajofinal;
import trabajofinal.controlador.ControladorPrincipal;
import trabajofinal.modelo.Contenedor;
import trabajofinal.utils.Generador;

public class Main {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        Generador.generarDatos(contenedor);
        new ControladorPrincipal(contenedor);
    }
}
