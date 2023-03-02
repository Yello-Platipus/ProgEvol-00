package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Seleccion {
    protected int tamPoblacion;

    public Seleccion() {}

    public abstract String toString();
    public int getTamPoblacion() {
        return this.tamPoblacion;
    }
    public void setTamPoblacion(int tamPoblacion) {
        this.tamPoblacion = tamPoblacion;
    }
    public abstract ArrayList<Individuo> seleccionar(ArrayList<Individuo> poblacion, int tamTorneo);
}
