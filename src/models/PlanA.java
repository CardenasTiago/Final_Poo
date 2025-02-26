package models;

public class PlanA extends PlanEstudio {
    public PlanA(String descripcion) {
        super(descripcion); // Descripción personalizada
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        return materia.getCorrelativas().stream()
                .allMatch(correlativa -> estudiante.getMateriasAprobadas().contains(correlativa));
    }
}