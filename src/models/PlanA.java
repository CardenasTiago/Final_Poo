package models;

public class PlanA extends PlanEstudio {
    public PlanA() {
        super("Plan A - Aprobó las cursadas de las correlativas");
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        return materia.getCorrelativas().stream()
                .allMatch(correlativa -> estudiante.getMateriasAprobadas().contains(correlativa));
    }
}