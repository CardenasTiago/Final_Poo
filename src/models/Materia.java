package models;

import java.util.*;

public class Materia {
    private String codigo;
    private String nombre;
    private boolean obligatoria;
    private int cuatrimestre;
    private List<Materia> correlativas;
    private boolean tienePromocion;

    public Materia(String codigo, String nombre, boolean obligatoria, int cuatrimestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.obligatoria = obligatoria;
        this.cuatrimestre = cuatrimestre;
        this.correlativas = new ArrayList<>();
        this.tienePromocion = false;
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public boolean isObligatoria() { return obligatoria; }
    public int getCuatrimestre() { return cuatrimestre; }
    public List<Materia> getCorrelativas() { return correlativas; }
    public void agregarCorrelativa(Materia materia) { correlativas.add(materia); }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }

    public void setTienePromocion(boolean tienePromocion) {
        this.tienePromocion = tienePromocion;
    }

    public boolean getTienePromocion() {
        return tienePromocion;
    }
}