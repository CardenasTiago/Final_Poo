import java.util.ArrayList;

public class Materia {
    String nombre;
    boolean obligatoria;
    String nota;
    boolean finalA;
    int cuatri;
    ArrayList <Materia> correlativas = new ArrayList<Materia>();
            
    public Materia(){
        
    }
    public Materia(boolean obligatoria, String nota, boolean finalA, String nombre, int cuatri){
        this.obligatoria = obligatoria;
        this.nota = nota;
        this.finalA = finalA;
        this.nombre = nombre;
        this.cuatri = cuatri;
     }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
            
    public void setObligatoria(boolean obligatoria){
        this.obligatoria = obligatoria;
    }
    
    public boolean getObligatoria(){
        return this.obligatoria;
    }
    
    public void setNota (String nota){
        this.nota = nota;
    }
    
    public String getNota(){
        return this.nota;
    }
    
    public void setFinalA(boolean finalA){
        this.finalA = finalA;
    }
    
    public boolean getFinalA(){
        return this.finalA;
    }
    
    public void setCuatri(int cuatri){
        this.cuatri = cuatri;
    }
    
    public int getCuatri(){
        return this.cuatri;
    }
    
    public void addCorrelativa(Materia materia){
        correlativas.add(materia);
    }
    public boolean cursadaCorrelativasA(){
        boolean aprobado = true;
        for(Materia materia : correlativas){
            if(Integer.parseInt(materia.getNota()) < 6){
                aprobado = false;
                break;
            }else{
                aprobado = true;
            }
        }
        if(aprobado){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean finalesCorrelativasA(){
        boolean aprobado = true;
        for(Materia materia : correlativas){
            if(!materia.finalA){
                aprobado = false;
                break;
            }else{
                aprobado = true;
            }
        }
        if(aprobado){
            return true;
        }else{
            return false;
        }
    }
}
