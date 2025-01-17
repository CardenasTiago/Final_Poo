package models;

public class VerificadorPlanEstudio {
    public static boolean puedeRecursarMateria(Estudiante estudiante, Materia materia) {
        PlanEstudio plan = estudiante.getCarrera().getPlanEstudio();

        switch (plan) {
            case PLAN_A: return verificarPlanA(estudiante, materia);
            case PLAN_B: return verificarPlanB(estudiante, materia);
            case PLAN_C: return verificarPlanC(estudiante, materia);
            case PLAN_D: return verificarPlanD(estudiante, materia);
            case PLAN_E: return verificarPlanE(estudiante, materia);
            default: return false;
        }
    }

    private static boolean verificarPlanA(Estudiante estudiante, Materia materia) {
        return materia.getCorrelativas().stream()
                .allMatch(correlativa -> estudiante.getMateriasAprobadas().contains(correlativa));
    }

    private static boolean verificarPlanB(Estudiante estudiante, Materia materia) {
        return materia.getCorrelativas().stream()
                .allMatch(correlativa -> estudiante.getFinalesAprobados().contains(correlativa));
    }

    private static boolean verificarPlanC(Estudiante estudiante, Materia materia) {
        return verificarPlanA(estudiante, materia) &&
                verificarFinalesCuatrimestres(estudiante, materia, 5);
    }

    private static boolean verificarPlanD(Estudiante estudiante, Materia materia) {
        return verificarPlanA(estudiante, materia) &&
                verificarFinalesCuatrimestres(estudiante, materia, 3);
    }

    private static boolean verificarPlanE(Estudiante estudiante, Materia materia) {
        return verificarPlanB(estudiante, materia) &&
                verificarFinalesCuatrimestres(estudiante, materia, 3);
    }

    private static boolean verificarFinalesCuatrimestres(Estudiante estudiante, Materia materia, int cantidadCuatrimestres) {
        int cuatrimestreActual = materia.getCuatrimestre();
        return estudiante.getCarrera().getTodasLasMaterias().stream()
                .filter(m -> m.getCuatrimestre() <= cuatrimestreActual - cantidadCuatrimestres)
                .allMatch(m -> estudiante.getFinalesAprobados().contains(m));
    }
}