package Cositas;

import Cositas.Individuo.Individuo;

public class AlgoritmoGenetico {
	private int tamPoblacion;
	private Individuo[] poblacion;
	private double[] fitness;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private int tamTorneo;
	private Individuo elMejor;
	private int pos_mejor;
	
	//TODO
	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones,
			double probCruce, double probMutacion) {
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
	}
	
	//TODO

}
