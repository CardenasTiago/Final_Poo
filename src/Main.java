import models.*;
import views.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        ArrayList<Carrera> carreras = new ArrayList<>();
        MenuPrincipal menuPrincipal = new MenuPrincipal(alumnos, carreras);
        menuPrincipal.setVisible(true);
    }
}