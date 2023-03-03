package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;
import java.util.Collections;

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

        Collections.sort(poblacion);
        double pFitness = poblacion.get(tamPoblacion-1).getFitness();
        if(pFitness >0)
            pFitness = 0;
        double pFitness2 = poblacion.get(0).getFitness();
        if(pFitness2 < 0){
            if(pFitness2 < pFitness)
                pFitness = Math.abs(pFitness2);
            else
                pFitness = Math.abs(pFitness);
        }

        for (Individuo ind : poblacion) {
            fitnessTotal += ind.getFitness() + pFitness;
        }

        double r = Math.random() * (1 / (double) tamPoblacion);
        double sum = 0;
        for(int i = 0; i < tamPoblacion; i++){
            sum += poblacion.get(i).getFitness();
            while(sum > r && seleccionados.size() < tamPoblacion){
                seleccionados.add(poblacion.get(i).clonar());
                r += 1 / (double) tamPoblacion;
            }
        }
        return seleccionados;
    }
}
