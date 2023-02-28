package Controller;

import Cositas.AlgoritmoGenetico;
import Cositas.Cruce.Cruce;
import Cositas.Cruce.CruceMonopunto;
import Cositas.Individuo.Individuo;
import Cositas.Seleccion.Seleccion;
import Cositas.Seleccion.SeleccionRuleta;

public class Controller {
    private AlgoritmoGenetico ag;

    public Controller(){
        ag = new AlgoritmoGenetico(100, 100, 0.6, 0.05, 0.01);
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
            i++;
            ag.getMejor();
        }
        //devolver mejor
        ag.getMejor();
    }

    public AlgoritmoGenetico getAG() {
        return ag;
    }
}
