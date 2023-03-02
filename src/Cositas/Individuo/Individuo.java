package Cositas.Individuo;

import java.util.Comparator;
import java.util.Random;
import Util.Converter;

public abstract class Individuo<T> implements Comparable<Individuo>{
	protected T[] cromosoma;
	protected int[] tamGenes;
	protected double min[];
	protected double max[];
	protected Random rand;
	protected double precision;
	protected int d;
	//protected Comparator comp;

	public Individuo(double precision,int d) {
		this.rand = new Random();
		this.precision = precision;
		this.d = d;
	}

	public abstract double getFitness();
	
	public abstract int tamGen( double min, double max);

	public abstract double getFenotipo(int x);

	public double[] getMin(){return min;}

	public double[] getMax(){return max;}

	public T[] getCromosoma() {
		return cromosoma;
	}

	public Random getRand(){return rand;}

	public String toString(){
		int n = tamGenes.length;
		String r = "			Mejor solucion = ";
		for(int i = 1; i <= n; i++){
			r += "X" + i + "(" + getFenotipo(i-1) + ")";
			if(i < n-1)
				r+= ", ";
			else if(i == n-1)
				r +=" y ";
		}
		return r;
	}
}
