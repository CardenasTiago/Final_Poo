package models;

import java.util.ArrayList;
import java.util.List;

public abstract class PlanEstudio {
    private String descripcion;
    private List<Materia> materiasObligatorias;
    private List<Materia> materiasOptativas;

    public PlanEstudio(String descripcion) {
        this.descripcion = descripcion;
        this.materiasObligatorias = new ArrayList<>();
        this.materiasOptativas = new ArrayList<>();
    }

    public void agregarMateriaObligatoria(Materia materia) {
        materiasObligatorias.add(materia);
    }

    public void agregarMateriaOptativa(Materia materia) {
        materiasOptativas.add(materia);
    }

    public List<Materia> getMateriasObligatorias() {
        return materiasObligatorias;
    }

    public List<Materia> getMateriasOptativas() {
        return materiasOptativas;
    }

    public List<Materia> getTodasLasMaterias() {
        List<Materia> todasLasMaterias = new ArrayList<>();
        todasLasMaterias.addAll(materiasObligatorias);
        todasLasMaterias.addAll(materiasOptativas);
        return todasLasMaterias;
    }

    public abstract boolean puedeRecursarMateria(Estudiante estudiante, Materia materia);

    @Override
    public String toString() {
        return descripcion;
    }
}