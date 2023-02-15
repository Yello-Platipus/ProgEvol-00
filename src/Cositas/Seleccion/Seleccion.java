package Cositas.Seleccion;

public abstract class Seleccion {
    protected int tamPoblacion;

    public Seleccion(int tamPoblacion) {
        this.tamPoblacion = tamPoblacion;
    }

    public int getTamPoblacion() {
        return this.tamPoblacion;
    }
    public void setTamPoblacion(int tamPoblacion) {
        this.tamPoblacion = tamPoblacion;
    }
    public abstract int[] seleccionar(double fitness[]);
}
