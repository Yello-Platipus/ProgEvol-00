package Cositas.Cruce;

import Cositas.Individuo.Individuo;

public class CruceUniforme extends Cruce{
    @Override
    public void cruzar(Individuo i1, Individuo i2) {

        for(int i = 0; i < i1.getCromosoma().length; i++){
            if(Math.random() < 0.5){ //0.5 por poner un numero
                Object aux = i1.getCromosoma()[i];
                i1.getCromosoma()[i] = i2.getCromosoma()[i];
                i2.getCromosoma()[i] = aux;
            }

        }
    }
}
