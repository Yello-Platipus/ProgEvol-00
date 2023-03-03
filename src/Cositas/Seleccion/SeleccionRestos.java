package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;

public class SeleccionRestos extends Seleccion{
    @Override
    public String toString() {
        return "Seleccion por restos";
    }

    @Override
    public ArrayList<Individuo> seleccionar(ArrayList<Individuo> poblacion, int tamTorneo) {
        int tamPoblacion = poblacion.size();
        double fitnessTotal = 0;
        ArrayList<Individuo> seleccionados = new ArrayList<>();
        for(Individuo i : poblacion)
            fitnessTotal += i.getFitness();

        for (int i = 0; i < tamPoblacion; i++) {
            if(tamPoblacion * (poblacion.get(i).getFitness() / fitnessTotal) > 1)
                seleccionados.add(poblacion.get(i).clonar());
        }
        while(seleccionados.size() < tamPoblacion) // El resto se selecciona de manera aleatoria
            seleccionados.add(poblacion.get((int) (Math.random() * tamPoblacion)).clonar());

        return seleccionados;
    }
}
