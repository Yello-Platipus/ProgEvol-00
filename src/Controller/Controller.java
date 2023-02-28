package Controller;

import Cositas.AlgoritmoGenetico;
import Cositas.Cruce.Cruce;
import Cositas.Cruce.CruceMonopunto;
import Cositas.Individuo.Individuo;
import Cositas.Seleccion.Seleccion;
import Cositas.Seleccion.SeleccionRuleta;

public class Controller {
    //private AlgoritmoGenetico ag;
    private double numGen[];
    private double mejorGen[];
    private double mejorAbs[];
    private double mediaGen[];
    private int maxGen;
    public Controller(){
        //ag = new AlgoritmoGenetico(100, 100, 0.6, 0.05, 0.01);
    }

    public void run(AlgoritmoGenetico ag) {
        //ag = new AlgoritmoGenetico(100, 100, 0.6, 0.05, 0.01);

        maxGen = ag.getMaxGeneraciones() ;
        int i = 1;
        ag.initPob();
        ag.evalPob();
        while(i <= maxGen) {
            numGen[i-1] = i;
            ag.generarElite();
            ag.selPob();
            ag.cruzPob();
            ag.mutPob();
            ag.introducirElite();
            ag.evalPob();
            mediaGen[i-1] = ag.calcularMediaGen();
            mejorGen[i-1] = ag.getMejor();

            if(i-1 == 0){mejorAbs[0] = mejorGen[0];}
            else{
                if(mejorAbs[i-2] < mejorGen[i-1]){
                    mejorAbs[i-1] = mejorGen[i-1];
                }
            }
        }
    }

    //public AlgoritmoGenetico getAG() {return ag;    }

    public double[] getNumGen() { return numGen;}

    public double[] getMejorGen() { return mejorGen;}

    public double[] getMejorAbs(){return mejorAbs;}

    public double[] getMediaGen(){return mediaGen;}
}
