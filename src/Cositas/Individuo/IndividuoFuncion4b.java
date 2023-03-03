package Cositas.Individuo;

import Util.Converter;

public class IndividuoFuncion4b extends Individuo<Double>{
    private int m;
    public IndividuoFuncion4b(double precision,int d) {
        super(precision, d);
        min = new double[d];
        max = new double[d];
        m = 10;
        for(int i = 0; i< d; i++){
            min[i] = 0;
            max[i] = Math.PI;
        }

        this.cromosoma = new Double[d];
        for (int i = 0; i < d; i++) this.cromosoma[i] = this.getRand().nextDouble()*max[0];
    }

    public IndividuoFuncion4b(Individuo ind){
        super(ind);
        int tamTotal = 0;
        for(int i = 0; i< d; i++)
            tamTotal += tamGenes[i];
        this.cromosoma = new Double[tamTotal];
        for (int i = 0; i < tamTotal; i++)
            this.cromosoma[i] = (Double) ind.getCromosoma()[i];
    }
    public IndividuoFuncion4b(Individuo ind, Double[] cromosoma){
        super(ind, cromosoma);
    }
    public double getValor() {
        double sumatorio = 0;
        for(int i = 0; i < d; i++){
            sumatorio += Math.sin(cromosoma[i])*Math.pow(Math.sin(((i-1) * Math.pow(cromosoma[i],2))/Math.PI), 2*m);
        }
        return -sumatorio;
    }

    public double getFitness() {
        return this.getValor();
    }

    public int tamGen( double min, double max) {
        return (int) (Math.log10(((max - min) / precision) + 1) / Math.log10(2));
    }

    public double getFenotipo(int x) {
        return cromosoma[x];
    }

    @Override
    public void setCromosoma(int i, Double o) {
        cromosoma[i] = o;
    }

    @Override
    public int compareTo(Individuo o) { //Minimizar
        if(this.getFitness() > o.getFitness())
            return 1;
        else if(this.getFitness() < o.getFitness())
            return -1;
        return 0;
    }
    public Double nextRandom(){
        return getMin()[0] + (getMax()[0] - getMin()[0]) * getRand().nextDouble();
    }
    public Individuo clonar(){return new IndividuoFuncion4b(this);}

    public Individuo getHijo(Double[] cromosoma) {
        return new IndividuoFuncion4b(this,cromosoma);
    }
}
