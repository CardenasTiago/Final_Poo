package models;

import java.util.*;
import java.util.stream.Collectors;

public class Carrera {
    private String nombre;
    private PlanEstudio planEstudio;
    private int materiasOptativasRequeridas;

    public Carrera(String nombre, PlanEstudio planEstudio, int materiasOptativasRequeridas) {
        this.nombre = nombre;
        this.planEstudio = planEstudio;
        this.materiasOptativasRequeridas = materiasOptativasRequeridas;
    }

    // Getters y métodos
    public String getNombre() { 
        return nombre; 
    }

    public PlanEstudio getPlanEstudio() { 
        return planEstudio; 
    }

    public int getMateriasOptativasRequeridas() {
        return materiasOptativasRequeridas;
    }

    /**
     * Obtiene todas las materias de la carrera, tanto obligatorias como optativas.
     * @return Lista de todas las materias.
     */
    public List<Materia> getTodasLasMaterias() {
        return planEstudio.getTodasLasMaterias();
    }

    /**
     * Agrega una materia obligatoria a la carrera.
     * @param materia La materia obligatoria a agregar.
     */
    public void agregarMateriaObligatoria(Materia materia) {
        planEstudio.agregarMateriaObligatoria(materia);
    }

    /**
     * Agrega una materia optativa a la carrera.
     * @param materia La materia optativa a agregar.
     */
    public void agregarMateriaOptativa(Materia materia) {
        planEstudio.agregarMateriaOptativa(materia);
    }

    /**
     * Obtiene las materias disponibles para que un estudiante se inscriba.
     * @param estudiante El estudiante que desea inscribirse.
     * @return Lista de materias disponibles.
     */
    public List<Materia> getMateriasDisponibles(Estudiante estudiante) {
        return getTodasLasMaterias().stream()
                .filter(materia -> !estudiante.getMateriasInscriptas().contains(materia)) // No está inscripto
                .filter(materia -> !estudiante.getFinalesAprobados().contains(materia))   // No la aprobó
                .filter(materia -> planEstudio.puedeRecursarMateria(estudiante, materia)) // Puede recursar según el plan
                .collect(Collectors.toList());
    }

    /**
     * Verifica si un estudiante ha completado la carrera.
     * @param estudiante El estudiante a verificar.
     * @return true si el estudiante ha completado la carrera, false en caso contrario.
     */
    public boolean haCompletado(Estudiante estudiante) {
        List<Materia> materiasObligatorias = planEstudio.getMateriasObligatorias();
        List<Materia> materiasOptativas = planEstudio.getMateriasOptativas();

        // Verifica si el estudiante aprobó todas las materias obligatorias
        boolean obligatoriasAprobadas = materiasObligatorias.stream()
                .allMatch(materia -> estudiante.getFinalesAprobados().contains(materia));

        // Cuenta cuántas materias optativas ha aprobado
        long optativasAprobadas = materiasOptativas.stream()
                .filter(materia -> estudiante.getFinalesAprobados().contains(materia))
                .count();

        // Verifica si cumplió con las materias obligatorias y optativas requeridas
        return obligatoriasAprobadas && optativasAprobadas >= materiasOptativasRequeridas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}