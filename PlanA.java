public class PlanA extends Plan{
    String nombre = "Plan A";
    
    public PlanA(){
        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public boolean puedeCursar(Materia materia){
        return true;
    }
}
