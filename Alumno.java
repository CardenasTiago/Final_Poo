
import java.util.ArrayList;
public class Alumno {
    private String nombre;
    private Integer legajo;
    private String email;
    private ArrayList<Carrera> carreras; 
    private ArrayList<Materia> materiasCursando;
    private ArrayList<Materia> materiasAprobadas;

    public Alumno() {
        this.nombre = "";
        this.legajo = 0;
        this.email = "";
        materiasAprobadas = new ArrayList<>();
        carreras = new ArrayList<>();
        materiasCursando = new ArrayList<>();
    }
    
    public Alumno(String nombre, Integer legajo, String email){
        this.nombre = nombre;
        this.legajo = legajo;
        this.email = email;
        materiasAprobadas = new ArrayList<>();
        carreras = new ArrayList<>();
        materiasCursando = new ArrayList<>();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Integer getLegajo(){
        return this.legajo;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    } 
    
    public void setLegajo(Integer legajo){
        this.legajo = legajo;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    
    public ArrayList<Carrera> getCarrera(){
        return this.carreras;
    }
    
    public void addAprobada(Materia materia){
        materiasAprobadas.add(materia);
    }
    
    public boolean materiaAprobada(Materia materia1){
        boolean found = false;
        for(Materia materia : materiasAprobadas){
            if(materia.equals(materia1)){
                found = true;
                break;
            }
        }
        return found;
    }
    
    public void inscribirMateria(Materia materia, String carrera1){
        for(Carrera carrera2 : carreras ){
            if(carrera2.getNombre().equals(carrera1)){
                materiasCursando.add(materia);
            }
        }
    }
    
    public void agregarMateriaAprobada(Materia materia, String carrera1){
        for(Carrera carrera2 : carreras){
            if(carrera2.getNombre().equals(carrera1)){
                materiasAprobadas.add(materia);
            }
        }   
    }
}
