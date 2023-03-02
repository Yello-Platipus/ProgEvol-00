package Cositas;

import Cositas.Cruce.Cruce;
import Cositas.Funcion.Funcion;
import Cositas.Individuo.Individuo;
import Cositas.Individuo.IndividuoFuncion1;
import Cositas.Mutacion.*;
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
	private double elitismo;
	private int numElite;
	private Individuo elite[];
	private Comparator<Individuo> comp; // Mayor a menor

	private Seleccion sel;
	private Cruce cruce;
	private Mutacion mut;
	private Funcion func;

	//TODO

	public AlgoritmoGenetico(){}

	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones,
			double probCruce, double probMutacion) {
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
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
			Individuo ind = poblacion.get(i);
			fitness[i] = ind.getFitness();
			if(ind.compareTo(elMejor) == -1){
				elMejor = ind;
				pos_mejor = i;
			}
		}
	}

	public void initPob(){
		poblacion = new ArrayList<Individuo>();
		for(int i = 0; i < tamPoblacion; i++) {
			poblacion.add(func.crearIndividuo());
		}
	}

	public void selPob(){
		poblacion = sel.seleccionar(poblacion, tamTorneo);

	}

	public void cruzPob(){
		for(int i = 0; i < tamPoblacion - 1; i += 2){
			if(Math.random() < probCruce){
				cruce.cruzar(poblacion.get(i), poblacion.get(i+1));
			}
		}
	}

	public void mutPob(){
		for(int i = 0; i < tamPoblacion; i++){
			mut.mutar(poblacion.get(i), probMutacion);
		}
	}

	public double getMejor() { return poblacion.get(pos_mejor).getFitness();}

	public void generarElite(){
		this.numElite = (int) elitismo * tamPoblacion;
		elite = new Individuo[numElite];
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
			fitness[i] = elite[i].getFitness();
		}
		poblacion.sort(comp);
	}

	public double calcularMediaGen(){
		int suma = 0;
		for(int i = 0; i < tamPoblacion; i++){
			suma += fitness[i];
		}
		return suma/tamPoblacion;
	}

	public Individuo getMejorIndividuo(){
		return elMejor;
	}
	//Getters y setters

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

	public int getPos_mejor() {
		return pos_mejor;
	}

	public Seleccion getSel() {
		return sel;
	}

	public void setSel(Seleccion sel) {
		this.sel = sel;
	}

	public Cruce getCruce() {
		return cruce;
	}

	public void setCruce(Cruce cruce) {
		this.cruce = cruce;
	}

	public Mutacion getMut() {
		return mut;
	}

	public void setMut(Mutacion mut) {
		this.mut = mut;
	}

	public Funcion getFunc() {
		return func;
	}

	public void setFunc(Funcion func) {
		this.func = func;
	}

	public void setElitismo(double elitismo) {
		this.elitismo = elitismo;
	}

	public double getElitismo(){return elitismo;}
}
