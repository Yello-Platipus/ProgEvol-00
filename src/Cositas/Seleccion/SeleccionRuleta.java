package Cositas.Seleccion;

public class SeleccionRuleta extends Seleccion{
    private final String nombre = "Ruleta";
    private double[] fitness;

    public SeleccionRuleta(int tamPoblacion) {
        super(tamPoblacion);
    }

public int[] seleccionar(double fitness[]){
        int[] seleccionados = new int[this.tamPoblacion];
        double[] fitnessAcumulado = new double[fitness.length];
        double fitnessTotal = 0;
        for(int i = 0; i < fitness.length; i++){
            fitnessTotal += fitness[i];
            fitnessAcumulado[i] = fitnessTotal;
        }
        for(int i = 0; i < this.tamPoblacion; i++){
            double aleatorio = Math.random() * fitnessTotal;
            for(int j = 0; j < fitness.length; j++){
                if(aleatorio < fitnessAcumulado[j]){
                    seleccionados[i] = j;
                    break;
                }
            }
        }
        return seleccionados;
    }
}
