package Controller;

import Cositas.AlgoritmoGenetico;
import Cositas.Cruce.Cruce;
import Cositas.Cruce.CruceMonopunto;
import Cositas.Individuo.Individuo;
import Cositas.Seleccion.Seleccion;
import Cositas.Seleccion.SeleccionRuleta;

public class Controller {
    public Individuo run() {
        AlgoritmoGenetico ag = new AlgoritmoGenetico(100, 100, 0.7, 0.001);
        Seleccion sel = new SeleccionRuleta(100);
        Cruce cruce = new CruceMonopunto();
        ag.initPob();
        ag.evalPob();
        int g = 0 ;
        int i = 0;
        while(i < g) {
            ag.selPob(sel);
            ag.cruzPob(cruce);
            ag.mutPob();
            //evaluar poblacion
        }
        //devolver mejor
        return null;
    }
}
