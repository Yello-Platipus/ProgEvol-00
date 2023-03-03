package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;
import java.util.Comparator;

public class SeleccionTorneoDeterminista  extends Seleccion{

    private static final int k = 3;

    public SeleccionTorneoDeterminista() {
        super();
    }

    @Override
    public String toString() {
        return "Seleccion por torneo determinista";
    }

    @Override
    public ArrayList<Individuo> seleccionar(ArrayList<Individuo> poblacion, int tamTorneo) {
        ArrayList<Individuo> ret = new ArrayList<Individuo>(tamTorneo);

        for(int i = 0; i < tamTorneo; i++){
            ArrayList<Individuo> aux = new ArrayList<Individuo>(k);
            for(int j = 0; j < k; j++){
                aux.add(poblacion.get((int) (Math.random() * tamTorneo)));
            }
            aux.sort(Individuo::compareTo);
            ret.add(aux.get(0).clonar());
        }

        return ret;
    }
}
