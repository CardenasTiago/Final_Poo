package models;

public class PlanB extends Plan{
    String nombre = "Plan B";

    public PlanB(){

    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public boolean puedeCursar(Materia materia){
        return true;
    }
}