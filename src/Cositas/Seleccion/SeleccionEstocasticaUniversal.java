package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;

public class SeleccionEstocasticaUniversal extends Seleccion{
    @Override
    public String toString() {
        return "Seleccion Estocastica Universal";
    }

    @Override
    public ArrayList<Individuo> seleccionar(ArrayList<Individuo> poblacion, int tamTorneo) {
        int tamPoblacion = poblacion.size();
        ArrayList<Individuo> seleccionados = new ArrayList<>();
        double fitnessTotal = 0;

        for (Individuo ind : poblacion) {
            fitnessTotal += ind.getFitness();
        }

        double r = Math.random() * (1 / tamPoblacion);
        double sum = 0;
        for(int i = 0; i < tamPoblacion; i++){
            sum += poblacion.get(i).getFitness();
            while(sum > r){
                seleccionados.add(poblacion.get(i).clonar());
                r += 1 / tamPoblacion;
            }
        }
        return seleccionados;
    }
}
