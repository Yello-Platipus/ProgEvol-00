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
        double pFitness = Math.abs(poblacion.get(tamPoblacion-1).getFitness());

        for(int i = 0; i < tamPoblacion; i++){
            fitnessTotal += poblacion.get(i).getFitness() + pFitness;
            fitnessAcumulado[i] = fitnessTotal;
        }
        for(int i = 0; i < tamPoblacion; i++){
            double aleatorio = Math.random() * fitnessTotal;
            for(int j = 0; j < tamPoblacion; j++){
                if(aleatorio < fitnessAcumulado[j] ){
                    seleccionados.add(poblacion.get(i).clonar());
                    break;
                }
            }
        }
        return seleccionados;
    }
}
