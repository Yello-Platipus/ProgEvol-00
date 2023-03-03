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
        tamPoblacion = poblacion.size();
        ArrayList<Individuo> seleccionados = new ArrayList<Individuo>(tamPoblacion);
        fitness = new double[tamPoblacion];
        double fitnessTotal = 0;
        double[] probAcum = new double[tamPoblacion];

        Collections.sort(poblacion);
        for(int i = 0; i < tamPoblacion; i++){
            fitness[i] = poblacion.get(0).getFitness();
        }

        int q = 1;
        while(fitness[0] == fitness[q]){
            q++;
            if(fitness[0] > fitness[q])
                corregirMinimizar(fitness[0]);
            else if(fitness[0] < fitness[q])
                corregirMaximizar(fitness[0]);
        }
        for(int i = 0 ; i < tamPoblacion; i++){
            fitnessTotal = fitness[i];
        }
        for(int i = 0 ; i < tamPoblacion; i++){
            probAcum[i] = fitness[i]/fitnessTotal;
            if(i > 0)
                probAcum[i] += probAcum[i-1];
        }

        for(int i = 0; i < tamPoblacion; i++){
            double aleatorio = Math.random() * fitnessTotal;
            for(int j = 0; j < tamPoblacion; j++){
                if(aleatorio < probAcum[j]){
                    seleccionados.add(poblacion.get(j).clonar());
                    break;
                }
            }
        }
        return seleccionados;
    }

    @Override
    public void corregirMinimizar(double max) {
        for(int i = 0; i < this.tamPoblacion; i++)
            this.fitness[i] = (1.05 * max) - this.fitness[i];
    }

    @Override
    public void corregirMaximizar(double min) {
        for(int i = 0; i < this.tamPoblacion; i++)
            this.fitness[i] = this.fitness[i] + Math.abs(min);
    }
}
