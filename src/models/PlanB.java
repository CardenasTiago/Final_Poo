package models;

public class PlanB extends PlanEstudio {
    public PlanB() {
        super("Plan B - Aprobó los finales de las correlativas");
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        return materia.getCorrelativas().stream()
                .allMatch(correlativa -> estudiante.getFinalesAprobados().contains(correlativa));
    }
}