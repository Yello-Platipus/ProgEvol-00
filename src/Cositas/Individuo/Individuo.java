package Cositas.Individuo;

import java.util.Random;

public abstract class Individuo<T> {
	protected T[] cromosoma;
	protected int[] tamGenes;
	protected double min[];
	protected double max[];
	protected double valorError;
	protected Random rand;
	protected double precision;
	
	public int tamGen(double valorError, double min, double max) {
		return (int) (Math.log10(((max - min) / precision) + 1) / Math.log10(2));
	}
	private int bin2dec(int x) {
		int tam = tamGenes[x];
		int ini = 0;
		for(int i = 0; i < x; i++) {
			ini += tamGenes[i];
		}
		int ret = 0;
		for(int i = 0 + ini; i < tam + ini; i++) {
			if((boolean) cromosoma[i])
				ret += Math.pow(2,tam - i);
		}
		return ret;
	}
	public double getFenotipo(int x) {
		return this.min[x] + bin2dec(x)*(this.max[x] - this.min[x])/(Math.pow(2,cromosoma.length) - 1);
	}
}
