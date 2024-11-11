import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        ArrayList<Carrera> carreras = new ArrayList<>();
        MenuPrincipal menuPrincipal = new MenuPrincipal(alumnos);
        menuPrincipal.setVisible(true);
    }
}
