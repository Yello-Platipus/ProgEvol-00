package Cositas;

import Cositas.Cruce.Cruce;
import Cositas.Individuo.Individuo;
import Cositas.Individuo.IndividuoFuncion1;
import Cositas.Seleccion.Seleccion;

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
	private double elitismo;
	private Individuo elite[];
	//TODO
	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones,
			double probCruce, double probMutacion, double elitismo) {
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.elitismo = elitismo;
	}
	public void evalPob(){
		this.fitness = new double[this.tamPoblacion];
		this.pos_mejor = 0;
		this.elMejor = this.poblacion[0];
		for(int i = 0; i < this.tamPoblacion; i++){
			this.fitness[i] = this.poblacion[i].getFitness();
			if(this.fitness[i] > this.elMejor.getFitness()){
				this.elMejor = this.poblacion[i];
				this.pos_mejor = i;
			}
			getMejor();
		}
	}

	public void initPob(){
		this.poblacion = new Individuo[this.tamPoblacion];
		for(int i = 0; i < this.tamPoblacion; i++) this.poblacion[i] = new IndividuoFuncion1();
	}

	public void selPob(Seleccion sel){
		int aux[] = sel.seleccionar(this.fitness);
		for(int i = 0; i < this.tamPoblacion; i++)
			this.poblacion[i] = this.poblacion[aux[i]];
	}

	public void cruzPob(Cruce cruce){
		for(int i = 0; i < this.tamPoblacion; i+=2){
			if(Math.random() < this.probCruce){
				cruce.cruzar(this.poblacion[i], this.poblacion[i+1]);
			}
		}
	}

	public void mutPob(){
		for(int i = 0; i < this.tamPoblacion; i++){
			this.poblacion[i].mutar(probMutacion);
		}
	}

	public void getMejor() { System.out.println("El mejor tiene un maximo de " + poblacion[pos_mejor].getFitness() + " " + poblacion[pos_mejor].getFenotipo(0) + " " + poblacion[pos_mejor].getFenotipo(1));}

	public void generarElite(){
		int numElite = (int)elitismo*tamPoblacion;
		elite = new Individuo[numElite];
		for(int i = 0; i < numElite; i++){

		}
	}
}
