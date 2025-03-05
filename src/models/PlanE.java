package models;

import java.util.List;

public class PlanE extends PlanEstudio {
    public PlanE(String descripcion) {
        super(descripcion);
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        // Verificar correlativas aprobadas (cursada)
        List<Materia> correlativas = materia.getCorrelativas();
        List<Materia> finalesAprobados = estudiante.getMateriasAprobadas();

        for (Materia correlativa : correlativas) {
            if (!finalesAprobados.contains(correlativa)) {
                return false;
            }
        }

        // Verificar finales aprobados de los 3 cuatrimestres previos
        int cuatrimestreMateria = materia.getCuatrimestre();
        int cuatrimestreInicio = Math.max(1, cuatrimestreMateria - 3); // Asegurar que no sea negativo

        List<Materia> todasLasMaterias = estudiante.getCarrera().getTodasLasMaterias();

        for (Materia m : todasLasMaterias) {
            if (m.getCuatrimestre() >= cuatrimestreInicio && m.getCuatrimestre() < cuatrimestreMateria) {
                if (!finalesAprobados.contains(m)) {
                    return false;
                }
            }
        }

        return true; 
    }
}