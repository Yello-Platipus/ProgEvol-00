package Cositas;

import Cositas.Cruce.Cruce;
import Cositas.Individuo.Individuo;
import Cositas.Individuo.IndividuoFuncion1;
import Cositas.Seleccion.Seleccion;
import com.sun.xml.internal.ws.db.DatabindingFactoryImpl;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.zip.Inflater;

import javafx.util.Pair;

public class AlgoritmoGenetico {
	private int tamPoblacion;
	private ArrayList<Individuo> poblacion;
	private double[] fitness;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;

	private int tamTorneo;
	private Individuo elMejor;
	private int pos_mejor;
	private int numElite;
	private Individuo elite[];
	private Comparator<Individuo> comp; // Mayor a menor
	//TODO
	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones,
			double probCruce, double probMutacion, double elitismo) {
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.numElite = (int) elitismo * tamPoblacion;
		elite = new Individuo[numElite];

		comp = new Comparator<Individuo>() {
			@Override
			public int compare(Individuo o1, Individuo o2) {
				if(o1.getFitness() < o2.getFitness())
					return 1;
				else if(o1.getFitness() > o2.getFitness())
					return -1;
				return 0;
			}
		};
	}
	public void evalPob(){
		fitness = new double[tamPoblacion];
		pos_mejor = 0;
		elMejor = poblacion.get(0);
		for(int i = 0; i < tamPoblacion; i++){
			fitness[i] = poblacion.get(i).getFitness();
			if(fitness[i] > elMejor.getFitness()){
				elMejor = poblacion.get(i);
				pos_mejor = i;
			}
		}
	}

	public void initPob(){
		poblacion = new ArrayList<Individuo>();
		for(int i = 0; i < tamPoblacion; i++) {
			poblacion.add(new IndividuoFuncion1());
		}
	}

	public void selPob(Seleccion sel){
		int aux[] = sel.seleccionar(fitness);
		ArrayList<Individuo> listaAux = new ArrayList<>();
		for(int i = 0; i < tamPoblacion; i++){
			listaAux.add(poblacion.get(aux[i]));
		}
		poblacion = listaAux;
	}

	public void cruzPob(Cruce cruce){
		for(int i = 0; i < tamPoblacion; i+=2){
			if(Math.random() < probCruce){
				cruce.cruzar(poblacion.get(i), poblacion.get(i+1));
			}
		}
	}

	public void mutPob(){
		for(int i = 0; i < tamPoblacion; i++){
			poblacion.get(i).mutar(probMutacion);
		}
	}

	public void getMejor() { System.out.println("El mejor tiene un maximo de " + poblacion.get(pos_mejor).getFitness());}

	public void generarElite(){
		poblacion.sort(comp);
		for(int i = 0; i < numElite; i++){
			elite[i] = poblacion.get(i);
		}
	}

	public void introducirElite() {
		poblacion.sort(comp);
		for(int i = numElite - 1; i >= 0; i--){
			poblacion.remove(i);
			poblacion.add(elite[i]);
		}
		poblacion.sort(comp);
	}
	
	public int getTamPoblacion() {
		return tamPoblacion;
	}

	public void setTamPoblacion(int tamPoblacion) {
		this.tamPoblacion = tamPoblacion;
	}

	public ArrayList<Individuo> getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(ArrayList<Individuo> poblacion) {
		this.poblacion = poblacion;
	}

	public double[] getFitness() {
		return fitness;
	}

	public void setFitness(double[] fitness) {
		this.fitness = fitness;
	}

	public int getMaxGeneraciones() {
		return maxGeneraciones;
	}

	public void setMaxGeneraciones(int maxGeneraciones) {
		this.maxGeneraciones = maxGeneraciones;
	}

	public double getProbCruce() {
		return probCruce;
	}

	public void setProbCruce(double probCruce) {
		this.probCruce = probCruce;
	}

	public double getProbMutacion() {
		return probMutacion;
	}

	public void setProbMutacion(double probMutacion) {
		this.probMutacion = probMutacion;
	}

	public int getTamTorneo() {
		return tamTorneo;
	}

	public void setTamTorneo(int tamTorneo) {
		this.tamTorneo = tamTorneo;
	}

	public Individuo getElMejor() {
		return elMejor;
	}

	public void setElMejor(Individuo elMejor) {
		this.elMejor = elMejor;
	}

	public int getPos_mejor() {
		return pos_mejor;
	}

	public void setPos_mejor(int pos_mejor) {
		this.pos_mejor = pos_mejor;
	}
}
