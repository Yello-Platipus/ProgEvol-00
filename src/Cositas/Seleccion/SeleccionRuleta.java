package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SeleccionRuleta extends Seleccion{

    public SeleccionRuleta() {
        super();
    }

    @Override
    public String toString() {
        return "Seleccion por ruleta";
    }

    public ArrayList<Individuo> seleccionar(ArrayList<Individuo> poblacion, int tamTorneo){
        int tamPoblacion = poblacion.size();
        ArrayList<Individuo> seleccionados = new ArrayList<Individuo>(tamPoblacion);
        double[] fitnessAcumulado = new double[tamPoblacion];
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

        for(int i = 0; i < tamPoblacion; i++){
            fitnessTotal += poblacion.get(i).getFitness() + pFitness;
            fitnessAcumulado[i] = fitnessTotal;
        }
        for(int i = 0; i < tamPoblacion; i++){
            double aleatorio = Math.random() * fitnessTotal;
            for(int j = 0; j < tamPoblacion; j++){
                if(aleatorio < fitnessAcumulado[j]){
                    seleccionados.add(poblacion.get(j).clonar());
                    break;
                }
            }
        }
        return seleccionados;
    }
}
