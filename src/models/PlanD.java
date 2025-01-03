package models;

public class PlanD extends Plan{
    String nombre = "Plan D";

    public PlanD(){

    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public boolean puedeCursar(Materia materia){
        return true;
    }
}