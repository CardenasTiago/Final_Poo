package models;

import java.util.*;

public class Materia {
    private String codigo;
    private String nombre;
    private boolean obligatoria;
    private int cuatrimestre;
    private List<Materia> correlativas;
    private boolean tienePromocion;
    private double notaParcial;
    private double notaFinal;
    private boolean promocionado;

    public Materia(String codigo, String nombre, boolean obligatoria, int cuatrimestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.obligatoria = obligatoria;
        this.cuatrimestre = cuatrimestre;
        this.correlativas = new ArrayList<>();
        this.tienePromocion = false;
        this.notaParcial = 0;
        this.notaFinal = 0;
        this.promocionado = false;
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public boolean isObligatoria() { return obligatoria; }
    public int getCuatrimestre() { return cuatrimestre; }
    public List<Materia> getCorrelativas() { return correlativas; }
    public void agregarCorrelativa(Materia materia) { correlativas.add(materia); }
    public boolean eliminarCorrelativa(Materia materia) {return correlativas.remove(materia);}
    public boolean getTienePromocion() { return tienePromocion; }
    public void setTienePromocion(boolean tienePromocion) { this.tienePromocion = tienePromocion; }
    public double getNotaParcial() { return notaParcial; }
    public void setNotaParcial(double notaParcial) { this.notaParcial = notaParcial; }
    public double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(double notaFinal) { this.notaFinal = notaFinal; }
    public boolean isPromocionado() { return promocionado; }
    public void setPromocionado(boolean promocionado) { this.promocionado = promocionado; }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}