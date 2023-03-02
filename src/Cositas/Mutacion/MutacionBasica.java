package Cositas.Mutacion;

import Cositas.Individuo.*;
public class MutacionBasica extends Mutacion<Boolean>{

    @Override
    public String toString() {
        return "Mutacion basica";
    }

    public void mutar(Individuo ind, double probMutacion){
        if(ind.getCromosoma()[0].equals(new Double(1)))
            mutarDouble(ind, probMutacion);
        else
            mutarBoolean(ind,probMutacion);
    }

    private void mutarBoolean(Individuo<Boolean> ind, double probMutacion){
        boolean cambios = false;
        Boolean cromosoma[] = ind.getCromosoma();
        for(int i = 0; i < cromosoma.length; i++){
            if(ind.getRand().nextDouble() < probMutacion){
                cromosoma[i] = ind.getRand().nextBoolean();
                cambios = true;
            }
        }
        if(cambios){
            //TODO refrescar fenotipo
        }
    };
    private void mutarDouble(Individuo<Double> ind, double probMutacion){
        boolean cambios = false;
        Object cromosoma[] = ind.getCromosoma();
        for(int i = 0; i < cromosoma.length; i++){
            if(ind.getRand().nextDouble() < probMutacion){
                cromosoma[i] = ind.getMin()[i] + (ind.getMax()[i] - ind.getMin()[i])*ind.getRand().nextDouble();
                cambios = true;
            }
        }
        if(cambios){
            //TODO refrescar fenotipo
        }
    }
}
