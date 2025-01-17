package models;

import java.util.*;
import java.util.stream.Collectors;


public class Carrera {
    private String nombre;
    private PlanEstudio planEstudio;
    private List<Materia> materiasObligatorias;
    private List<Materia> materiasOptativas;
    private int materiasOptativasRequeridas;

    public Carrera(String nombre, PlanEstudio planEstudio, int materiasOptativasRequeridas) {
        this.nombre = nombre;
        this.planEstudio = planEstudio;
        this.materiasObligatorias = new ArrayList<>();
        this.materiasOptativas = new ArrayList<>();
        this.materiasOptativasRequeridas = materiasOptativasRequeridas;
    }

    // Getters y métodos
    public String getNombre() { return nombre; }
    public PlanEstudio getPlanEstudio() { return planEstudio; }
    public void agregarMateriaObligatoria(Materia materia) { materiasObligatorias.add(materia); }
    public void agregarMateriaOptativa(Materia materia) { materiasOptativas.add(materia); }

    public List<Materia> getTodasLasMaterias() {
        List<Materia> todasLasMaterias = new ArrayList<>();
        todasLasMaterias.addAll(materiasObligatorias);
        todasLasMaterias.addAll(materiasOptativas);
        return todasLasMaterias;
    }

    public List<Materia> getMateriasDisponibles(Estudiante estudiante) {
        return getTodasLasMaterias().stream()
                .filter(materia -> !estudiante.getMateriasInscriptas().contains(materia))
                .filter(materia -> !estudiante.getFinalesAprobados().contains(materia))
                .filter(materia -> VerificadorPlanEstudio.puedeRecursarMateria(estudiante, materia))
                .collect(Collectors.toList());
    }

    public boolean haCompletado(Estudiante estudiante) {
        boolean obligatoriasAprobadas = materiasObligatorias.stream()
                .allMatch(materia -> estudiante.getFinalesAprobados().contains(materia));

        long optativasAprobadas = materiasOptativas.stream()
                .filter(materia -> estudiante.getFinalesAprobados().contains(materia))
                .count();

        return obligatoriasAprobadas && optativasAprobadas >= materiasOptativasRequeridas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}