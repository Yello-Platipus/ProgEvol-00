package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;
import java.util.Comparator;

public class SeleccionTorneoDeterminista  extends Seleccion{

    private static final int k = 3;

    public SeleccionTorneoDeterminista(int tamPoblacion) {
        super();
    }

    @Override
    public String toString() {
        return "Seleccion por torneo determinista";
    }

    @Override
    public ArrayList<Individuo> seleccionar(ArrayList<Individuo> poblacion, int tamTorneo) {
        int tamPoblacion = poblacion.size();
        ArrayList<Individuo> ret = new ArrayList<Individuo>(tamPoblacion);
        ArrayList<Individuo> aux = new ArrayList<Individuo>(k);

        for(int i = 0; i < tamPoblacion; i++){
            for(int j = 0; j < k; j++){
                aux.set(j, poblacion.get((int) (Math.random() * tamPoblacion)));
            }
            ret.set(i, aux.get(0));
            for(int j = 1; j < k; j++){
                if(aux.get(j).getFitness() > ret.get(i).getFitness())
                    ret.set(i, aux.get(j));
            }
        }

        return ret;
    }
}
