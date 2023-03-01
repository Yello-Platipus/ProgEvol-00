package View;

import Controller.Controller;
import Cositas.AlgoritmoGenetico;
import Cositas.Seleccion.Seleccion;
import Cositas.Seleccion.SeleccionRuleta;
import View.ConfigPanel.*;

import javax.swing.*;
import java.awt.*;
import org.math.plot.*;

public class MainWindow extends JFrame {
    Controller cont;
    ConfigPanel cPanel;
    AlgoritmoGenetico ag;

    public MainWindow(Controller cont){
        super("Panel de configuracion");
        cPanel = new ConfigPanel<AlgoritmoGenetico>();
        this.cont = cont;
        init();
        ag = new AlgoritmoGenetico();
        cPanel.setTarget(ag);
        cPanel.initialize();
    }
    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        iniPanel();
        iniGrafica();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
        this.setVisible(true);
    }

    public void iniPanel(){
        cPanel.addOption(new IntegerOption<AlgoritmoGenetico>(
                "Poblacion", "Numero de individuos en la poblacion",
                "tamPoblacion", 1, Integer.MAX_VALUE));
        cPanel.addOption(new IntegerOption<AlgoritmoGenetico>(
                "Número de generaciones", "Numero de generaciones a ejecutar",
                "maxGeneraciones", 1, Integer.MAX_VALUE));
        cPanel.addOption(new DoubleOption<AlgoritmoGenetico>(
                "Probabilidad de cruce", "Probabilidad de que se produzca un cruce entre dos individuos",
                "probCruce", 0, 1));
        cPanel.addOption(new DoubleOption<AlgoritmoGenetico>(
                "Probabilidad de mutación", "Probabilidad de que se produzca una mutación en un individuo",
                "probMutacion", 0, 1));
        // TODO Falta la opción de la precisión
        /*cPanel.addOption(new DoubleOption<AlgoritmoGenetico>(
                "Precision", "Precision para la discretización del intervalo",
                "precision", 1, Integer.MAX_VALUE));*cPanel.addOption(new ChoiceOption<AlgoritmoGenetico>(
                "Tipo de seleccion", "Tipo de seleccion a utilizar",
                "tipoSeleccion", new Seleccion[]{new SeleccionRuleta(100)})); // TODO CAMBIAR*/
        cPanel.setSize(1000, 600);
        cPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.PAGE_AXIS));


        this.add(cPanel, BorderLayout.WEST);
    }

    public void iniGrafica(){
        // define your data
        double[] numGen = cont.getNumGen();
        double[] merjorGen = cont.getMejorGen();
        double[] mejorAbs = cont.getMejorAbs();
        double[] mediaGen = cont.getMediaGen();

        double[] x = { 1, 2, 3, 4, 5, 6 };
        double[] y = { 45, 89, 6, 32, 63, 12 };

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();

        // define the legend position
        plot.addLegend("SOUTH");

        // add a line plot to the PlotPanel
        plot.addLinePlot("my plot", x, y/*numGen, mejorGen*/);
        /*
        * plot.addLinePlot("Mejor Absoluto", numGen, mejorAbs);
        * plot.addLinePlot("Mejor Generacion", numGen, mejorGen);
        * plot.addLinePlot("Media Generacion", numGen, mediaGen);
        * */
        // put the PlotPanel in a JFrame like a JPanel

        plot.setSize(600, 600);
        this.add(plot, BorderLayout.CENTER);
    }
}
