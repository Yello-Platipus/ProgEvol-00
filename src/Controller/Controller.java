package Controller;

import Cositas.AlgoritmoGenetico;
import Cositas.Cruce.Cruce;
import Cositas.Cruce.CruceMonopunto;
import Cositas.Individuo.Individuo;
import Cositas.Seleccion.Seleccion;
import Cositas.Seleccion.SeleccionRuleta;

public class Controller {
    public void run() {
        AlgoritmoGenetico ag = new AlgoritmoGenetico(100, 100, 0.6, 0.05, 0.01);
        Seleccion sel = new SeleccionRuleta(100);
        Cruce cruce = new CruceMonopunto();
        ag.initPob();
        ag.evalPob();
        int g = 2 ;
        int i = 0;
        while(i < g) {
            ag.selPob(sel);
            ag.cruzPob(cruce);
            ag.mutPob();
            ag.evalPob();
            i++;
        }
        //devolver mejor
         ag.getMejor();
    }
}
