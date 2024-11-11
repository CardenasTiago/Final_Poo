
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Carrera {
    private Plan plan;
    private String nombre;
    private int cantCuatri;
    private ArrayList<Materia> materiasObligatorias;
    private ArrayList<Materia> materiasOptativas;
    
    
    public Carrera(Plan tipoPlan, String nombre,int cantCuatri){
        this.plan = tipoPlan;
        this.nombre = nombre;
        this.materiasObligatorias = new ArrayList<>();
        this.materiasOptativas = new ArrayList<>();
        this.cantCuatri = cantCuatri;
    }
    
    public void setTipoPlan(Plan tipoPlan) {
        this.plan = tipoPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Plan getTipoPlan() {
        return plan;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setCantCuatri(int cantCuatri){
        this.cantCuatri = cantCuatri;
    }
    
    public int getCantCuatri(){
        return this.cantCuatri;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + "/n" + "Plan de estudio: " + plan;
    }
    
    public void addMateria(Materia materia){
        if(materia.getCuatri() >= 1 && materia.getCuatri() <= this.cantCuatri){
            if(materia.obligatoria){
                materiasObligatorias.add(materia);
            }else{
                materiasOptativas.add(materia);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error en el numero de cuatrimestr");
        }
    }
    
    public boolean buscarMateria(Materia materia){
        boolean encontrada = false;
        for(Materia materiaBuscada: materiasObligatorias){
            if(materiaBuscada.getNombre().equals(materia.getNombre())){
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }
    
}
