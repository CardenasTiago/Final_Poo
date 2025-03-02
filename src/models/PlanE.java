package models;

public class PlanE extends PlanEstudio {
    public PlanE(String descripcion) {
        super(descripcion); // Descripción personalizada
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        boolean correlativasAprobadas = materia.getCorrelativas().stream()
                .allMatch(correlativa -> estudiante.getMateriasAprobadas().contains(correlativa));

        boolean finalesAprobados = estudiante.getCarrera().getTodasLasMaterias().stream()
                .filter(m -> m.getCuatrimestre() <= materia.getCuatrimestre() - 3)
                .allMatch(m -> estudiante.getMateriasAprobadas().contains(m));

        return correlativasAprobadas && finalesAprobados;
    }
}