package models;

import java.util.List;

public class PlanA extends PlanEstudio {
    public PlanA(String descripcion) {
        super(descripcion);
    }

    @Override
    public boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        List<Materia> correlativas = materia.getCorrelativas();
        List<Materia> cursadasAprobadas = estudiante.getCursadaAprobadas();
        
        for (Materia correlativa : correlativas) {
            if (!cursadasAprobadas.contains(correlativa)) {
                return false;
            }
        }
        return true;
    }
}