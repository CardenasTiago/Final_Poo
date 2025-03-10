package models;

import java.util.*;

public class Estudiante {
    private int legajo;
    private String nombre;
    private List<Materia> materiasInscriptas;
    private List<Materia> cursadaAprobadas;
    private List<Materia> materiasAprobados;
    private Carrera carrera;

    public Estudiante(int legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.materiasInscriptas = new ArrayList<>();
        this.cursadaAprobadas = new ArrayList<>();
        this.materiasAprobados = new ArrayList<>();
    }

    // Getters y setters
    public int getLegajo() { return legajo; }
    public String getNombre() { return nombre; }
    public List<Materia> getMateriasInscriptas() { return materiasInscriptas; }
    public List<Materia> getCursadaAprobadas() { return cursadaAprobadas; }
    public List<Materia> getMateriasAprobadas() { return materiasAprobados; }
    public Carrera getCarrera() { return carrera; }
    public void setCarrera(Carrera carrera) { this.carrera = carrera; }

    public void inscribirEnMateria(Materia materia) {
        materiasInscriptas.add(materia);
    }

    public void aprobarCursada(Materia materia) {
        cursadaAprobadas.add(materia);
    }

    public void aprobarFinal(Materia materia) {
        materiasInscriptas.remove(materia);
        materiasAprobados.add(materia);

    }

    @Override
    public String toString() {
        return legajo + " - " + nombre;
    }

    public void registrarNota(Materia materia, double notaParcial) {
        materia.setNotaParcial(notaParcial);

        if (materia.getTienePromocion() && notaParcial >= 7) {
            aprobarPorPromocion(materia);
        }
        else{
            if(materia.getNotaParcial() >= 4){
                aprobarCursada(materia);
            }
        }
    }

    public void registrarNotaFinal(Materia materia, double notaFinal) {
        boolean correlativasAprobadas = materia.getCorrelativas().stream()
                .allMatch(correlativa -> this.materiasAprobados.contains(correlativa));
    
        if (!correlativasAprobadas) {
            throw new IllegalStateException("No se puede aprobar el final. Debe aprobar primero las correlativas.");
        }
    
        materia.setNotaFinal(notaFinal);
        if (notaFinal >= 4) {
            aprobarFinal(materia);
        }
    }

    public void aprobarPorPromocion(Materia materia) {
        cursadaAprobadas.add(materia);
        materiasAprobados.add(materia);
    }

    public boolean tieneParcialAprobado(Materia materia) {
        return materia.getNotaParcial() >= 4;
    }

    public boolean tienePromocion(Materia materia) {
        return materia.getNotaParcial() >= 7 && materia.getTienePromocion();
    }

    public void aprobarMateria(Materia materia) {
        if (materiasInscriptas.contains(materia)) {
            materiasInscriptas.remove(materia);
            cursadaAprobadas.add(materia);
        }
    }


    public void actualizarMateriasDisponibles() {
        for (Materia materia : carrera.getPlanEstudio().getTodasLasMaterias()) {
            if (!materiasInscriptas.contains(materia) && !cursadaAprobadas.contains(materia)) {
                boolean correlativasAprobadas = materia.getCorrelativas().stream()
                        .allMatch(correlativa -> cursadaAprobadas.contains(correlativa));
                if (correlativasAprobadas) {
                    materiasInscriptas.add(materia);
                }
            }
        }
    }
}