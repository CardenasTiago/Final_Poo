package models;

public class PlanE extends PlanEstudio {
    public PlanE() {
        super("Plan E - Aprobó los finales de las correlativas y los finales de todas las materias de 3 cuatrimestres previos");
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        boolean correlativasAprobadas = materia.getCorrelativas().stream()
                .allMatch(correlativa -> estudiante.getFinalesAprobados().contains(correlativa));

        boolean finalesAprobados = estudiante.getCarrera().getTodasLasMaterias().stream()
                .filter(m -> m.getCuatrimestre() <= materia.getCuatrimestre() - 3)
                .allMatch(m -> estudiante.getFinalesAprobados().contains(m));

        return correlativasAprobadas && finalesAprobados;
    }
}
