package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;


public abstract class Seleccion {

    public Seleccion() {}

    public abstract String toString();
    public abstract ArrayList<Individuo> seleccionar(ArrayList<Individuo> poblacion, int tamTorneo);
}
