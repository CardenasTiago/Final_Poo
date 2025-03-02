package models;

public class PlanD extends PlanEstudio {
    public PlanD(String descripcion) {
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