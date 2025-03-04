package models;

import java.util.List;

public class PlanC extends PlanEstudio {
 public PlanC(String descripcion) {
        super(descripcion);
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        // Verificar correlativas aprobadas
        List<Materia> correlativas = materia.getCorrelativas();
        List<Materia> materiasAprobadas = estudiante.getMateriasAprobadas();
        
        for (Materia correlativa : correlativas) {
            if (!materiasAprobadas.contains(correlativa)) {
                return false;
            }
        }
        
        // Verificar finales aprobados de 5 cuatrimestres previos
        List<Materia> todasLasMaterias = estudiante.getCarrera().getTodasLasMaterias();
        int cuatrimestreMateria = materia.getCuatrimestre();
        
        for (Materia m : todasLasMaterias) {
            if (m.getCuatrimestre() <= cuatrimestreMateria - 5) {
                if (!materiasAprobadas.contains(m)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}