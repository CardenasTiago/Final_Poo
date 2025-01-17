package models;

public enum PlanEstudio {
    PLAN_A("Plan A - Cursadas de correlativas"),
    PLAN_B("Plan B - Finales de correlativas"),
    PLAN_C("Plan C - Cursadas correlativas + finales 5 cuatrimestres"),
    PLAN_D("Plan D - Cursadas correlativas + finales 3 cuatrimestres"),
    PLAN_E("Plan E - Finales correlativas + finales 3 cuatrimestres");

    private final String descripcion;

    PlanEstudio(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}