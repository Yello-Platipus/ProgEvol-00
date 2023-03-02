package Cositas.Seleccion;

import Cositas.Individuo.Individuo;

import java.util.ArrayList;

public class SeleccionTorneoAleatoria extends Seleccion{
    public SeleccionTorneoAleatoria() {
        super();
    }

    @Override
    public String toString() {
        return "Seleccion por torneo aleatorio";
    }

    @Override
    public ArrayList<Individuo> seleccionar(ArrayList<Individuo> poblacion, int tamTorneo) {
        int tamPoblacion = poblacion.size();
        ArrayList<Individuo> seleccionados = new ArrayList<Individuo>(tamPoblacion);
        ArrayList<Individuo> torneo = new ArrayList<Individuo>(2);
        double p = (Math.random() % 0.5) + 0.5;
        for(int i = 0; i < tamPoblacion; i++){
            torneo.set(0, poblacion.get((int) (Math.random() * tamPoblacion)));
            torneo.set(1, poblacion.get((int) (Math.random() * tamPoblacion)));
            if(Math.random() > p)
                seleccionados.set(i, torneo.get(0).compareTo(torneo.get(1)) == 1 ? torneo.get(0) : torneo.get(1));
            else
                seleccionados.set(i, torneo.get(0).compareTo(torneo.get(1)) == -1 ? torneo.get(0) : torneo.get(1));
        }
        return seleccionados;
    }
}
