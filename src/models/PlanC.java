package models;

public class PlanC extends Plan{
    String nombre = "Plan C";

    public PlanC(){

    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public boolean puedeCursar(Materia materia){
        return true;
    }
}