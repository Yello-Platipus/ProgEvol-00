package Cositas.Mutacion;

import Cositas.Individuo.Individuo;

public abstract class Mutacion<T> {
    public abstract String toString();
    public abstract void  mutar(Individuo<T> ind, double probMutacion);

}
