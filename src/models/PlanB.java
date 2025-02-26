package models;

public class PlanB extends PlanEstudio {
    public PlanB(String descripcion) {
        super(descripcion); // Descripción personalizada
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        return materia.getCorrelativas().stream()
                .allMatch(correlativa -> estudiante.getFinalesAprobados().contains(correlativa));
    }
}