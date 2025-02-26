package models;

import java.util.*;

public class Estudiante {
    private int legajo;
    private String nombre;
    private List<Materia> materiasInscriptas;
    private List<Materia> materiasAprobadas;
    private List<Materia> finalesAprobados;
    private Carrera carrera;

    public Estudiante(int legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.materiasInscriptas = new ArrayList<>();
        this.materiasAprobadas = new ArrayList<>();
        this.finalesAprobados = new ArrayList<>();
    }

    // Getters y setters
    public int getLegajo() { return legajo; }
    public String getNombre() { return nombre; }
    public List<Materia> getMateriasInscriptas() { return materiasInscriptas; }
    public List<Materia> getMateriasAprobadas() { return materiasAprobadas; }
    public List<Materia> getFinalesAprobados() { return finalesAprobados; }
    public Carrera getCarrera() { return carrera; }
    public void setCarrera(Carrera carrera) { this.carrera = carrera; }

    public void inscribirEnMateria(Materia materia) {
        materiasInscriptas.add(materia);
    }

    public void aprobarCursada(Materia materia) {
        materiasAprobadas.add(materia);
    }

    public void aprobarFinal(Materia materia) {
        finalesAprobados.add(materia);
    }

    @Override
    public String toString() {
        return legajo + " - " + nombre;
    }

    public void registrarNota(Materia materia, double notaParcial) {
        materia.setNotaParcial(notaParcial);

        // Si promociona, automáticamente aprueba la materia
        if (materia.getTienePromocion() && notaParcial >= 7) {
            aprobarPorPromocion(materia);
        }
    }

    public void registrarNotaFinal(Materia materia, double notaFinal) {
        materia.setNotaFinal(notaFinal);
        if (notaFinal >= 4) {
            aprobarFinal(materia);
        }
    }

    public void aprobarPorPromocion(Materia materia) {
        materiasAprobadas.add(materia);
        finalesAprobados.add(materia); // La promoción implica aprobar el final
    }

    public boolean tieneParcialAprobado(Materia materia) {
        return materia.getNotaParcial() >= 4;
    }

    public boolean tienePromocion(Materia materia) {
        return materia.getNotaParcial() >= 7 && materia.getTienePromocion();
    }
}