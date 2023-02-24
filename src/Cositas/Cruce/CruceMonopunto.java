package Cositas.Cruce;

import Cositas.Individuo.Individuo;

public class CruceMonopunto extends Cruce{
    @Override
    public void cruzar(Individuo i1, Individuo i2) {
        int tam = i1.getCromosoma().length;
        int corte = (int) (Math.random() * tam);
        for(int i = corte; i < tam; i++) {
            Object aux2 = i1.getCromosoma()[i];
            i1.getCromosoma()[i] = i2.getCromosoma()[i];
            i2.getCromosoma()[i] = aux2;
        }
    }
}
