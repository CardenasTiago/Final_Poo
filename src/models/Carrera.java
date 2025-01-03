package models;

import javax.swing.*;
import java.util.ArrayList;

public class Carrera {
    private String nombre;
    private int cantCuatri;
    private ArrayList<Materia> materiasObligatorias;
    private ArrayList<Materia> materiasOptativas;


    public Carrera(Plan tipoPlan, String nombre,int cantCuatri){
        this.nombre = nombre;
        this.materiasObligatorias = new ArrayList<>();
        this.materiasOptativas = new ArrayList<>();
        this.cantCuatri = cantCuatri;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void addMateria(Materia materia){
        if(materia.getCuatri() >= 1 && materia.getCuatri() <= this.cantCuatri){
            if(materia.getObligatoria()){
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
