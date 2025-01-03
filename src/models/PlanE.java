package models;

public class PlanE extends Plan{
    String nombre = "Plan E";

    public PlanE(){

    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public boolean puedeCursar(Materia materia){
        return true;
    }
}