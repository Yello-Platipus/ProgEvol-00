package Cositas.Individuo;

import Util.Converter;

public class IndividuoFuncion1 extends Individuo<Boolean> {

	public IndividuoFuncion1() {
		super();
		this.tamGenes = new int[2];
		this.min = new double[2];
		this.max = new double[2];
		this.min[0] = -3.000;
		this.min[1] = 4.100;
		this.max[0] = 12.100;
		this.max[1] = 5.800;
		this.valorError = 0.001;
		this.precision = 0.001;
		this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		for (int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
	}

	public double getValor() {
		double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
		return (21.5 + x1 * Math.sin(4 * Math.PI * x1) + x2 * Math.sin(20 * Math.PI * x2));
	}

	public double getFitness() {
		return this.getValor();
	}



	public int tamGen(double valorError, double min, double max) {
		return (int) (Math.log10(((max - min) / precision) + 1) / Math.log10(2));
	}

	public double getFenotipo(int x) {
		return this.min[x] + Converter.bin2dec(cromosoma, tamGenes, x)*(this.max[x] - this.min[x])/(Math.pow(2,cromosoma.length) - 1);
	}

	public void mutar(double probMutacion){
		//TODO
	}
}
