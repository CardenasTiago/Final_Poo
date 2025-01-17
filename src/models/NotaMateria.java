package models;

import java.util.*;

public class NotaMateria {
    private double notaParcial;
    private double notaFinal;
    private boolean promocionado;

    public NotaMateria() {
        this.notaParcial = 0;
        this.notaFinal = 0;
        this.promocionado = false;
    }

    public void setNotaParcial(double nota) {
        this.notaParcial = nota;
    }

    public void setNotaFinal(double nota) {
        this.notaFinal = nota;
    }

    public double getNotaParcial() { return notaParcial; }
    public double getNotaFinal() { return notaFinal; }
    public boolean isPromocionado() { return promocionado; }
    public void setPromocionado(boolean promocionado) { this.promocionado = promocionado; }
}