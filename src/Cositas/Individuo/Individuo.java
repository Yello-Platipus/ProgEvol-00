package Cositas.Individuo;

import java.util.Random;
import Util.Converter;

public abstract class Individuo<T> {
	protected T[] cromosoma;
	protected int[] tamGenes;
	protected double min[];
	protected double max[];
	protected double valorError;
	protected Random rand;
	protected double precision;

	public Individuo() {
		this.rand = new Random();
	}

	public abstract double getFitness();
	
	public abstract int tamGen(double valorError, double min, double max);

	public abstract double getFenotipo(int x);

	public T[] getCromosoma() {
		return cromosoma;
	}

	public abstract void mutar(double probMutacion);
}
