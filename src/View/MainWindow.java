package View;

import Controller.Controller;
import Cositas.AlgoritmoGenetico;
import Cositas.Mutacion.*;
import Cositas.Seleccion.*;
import Cositas.Funcion.*;
import Cositas.Cruce.*;
import View.ConfigPanel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.stage.Screen;
import org.math.plot.*;

public class MainWindow extends JFrame {
    private Controller cont;
    private ConfigPanel cPanel;
    private AlgoritmoGenetico ag;
    String mSol;
    public MainWindow(Controller cont){
        super("Panel de configuracion");
        cPanel = new ConfigPanel<AlgoritmoGenetico>();
        this.cont = cont;
        mSol = "            Mejor solucion: ";
        ag = new AlgoritmoGenetico();
        cPanel.setTarget(ag);
        init();

    }
    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        iniPanel();
        JButton ejecBoton = new JButton("Ejecutar");
        ejecBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cPanel.initialize();
                cont.run(ag);
                iniGrafica();
                mSol = cont.getMejorIndAbs().toString();
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setSize(1920, 1080);
                pack();
                setVisible(true);
            }
        });
        JButton resetBoton = new JButton("Reset");
        resetBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ag = new AlgoritmoGenetico();
                cPanel.setTarget(ag);
            }
        });
        JLabel mejorSol = new JLabel(mSol);
        JPanel panelSur = new JPanel(new BorderLayout());
        panelSur.add(ejecBoton, BorderLayout.EAST);
        panelSur.add(resetBoton,BorderLayout.WEST);
        panelSur.add(mejorSol, BorderLayout.CENTER);

        this.add(panelSur, BorderLayout.SOUTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
        this.setVisible(true);
    }

    public void iniPanel(){
        cPanel.addOption(new IntegerOption<AlgoritmoGenetico>(
                "Poblacion", "Numero de individuos en la poblacion",
                "tamPoblacion", 0, Integer.MAX_VALUE));
        cPanel.addOption(new IntegerOption<AlgoritmoGenetico>(
                "Numero de generaciones", "Numero de generaciones a ejecutar",
                "maxGeneraciones", 0, Integer.MAX_VALUE));
        cPanel.addOption(new DoubleOption<AlgoritmoGenetico>(
                "Probabilidad de cruce", "Probabilidad de que se produzca un cruce entre dos individuos",
                "probCruce", 0, 1));
        cPanel.addOption(new DoubleOption<AlgoritmoGenetico>(
                "Probabilidad de mutacin", "Probabilidad de que se produzca una mutacion en un individuo",
                "probMutacion", 0, 1));
        cPanel.addOption(new DoubleOption<AlgoritmoGenetico>(
               "Precision", "Precision para la discretización del intervalo",
               "precision", 0, 1));
        cPanel.addOption(new ChoiceOption<AlgoritmoGenetico>(
                "Tipo de seleccion", "Tipo de seleccion a utilizar",
                "sel", new Seleccion[]{new SeleccionRuleta(), new SeleccionTorneoAleatoria(), new SeleccionTorneoDeterminista(),
                                                new SeleccionEstocasticaUniversal()}));
        cPanel.addOption(new ChoiceOption<AlgoritmoGenetico>(
                "Tipo de funcion", "Tipo de funcion",
                "func", new Funcion[]{new Funcion1(), new Funcion2(), new Funcion3(),new Funcion4a(), new Funcion4b()}));
        cPanel.addOption(new ChoiceOption<AlgoritmoGenetico>(
                "Tipo de cruce", "Tipo de cruce",
                "cruce", new Cruce[]{new CruceMonopunto(), new CruceUniforme()}));
        cPanel.addOption(new ChoiceOption<AlgoritmoGenetico>(
                "Tipo de mutacion", "Tipo de mutacion",
                "mut", new Mutacion[]{new MutacionBasica()}));
        cPanel.addOption(new IntegerOption<AlgoritmoGenetico>(
                "d", "Dimensiones de la funcion 4",
                "d", 1, Integer.MAX_VALUE));
        cPanel.setSize(1000, 600);
        cPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.PAGE_AXIS));
        cPanel.addOption(new DoubleOption<AlgoritmoGenetico>(
                "Proporcion de elite", "Proporcion de la poblacion que se guarda como elite",
                "elitismo", 0.1, 1));

        this.add(cPanel, BorderLayout.WEST);
    }

    public void iniGrafica(){
        // define your data
        double[] numGen = cont.getNumGen();
        double[] mejorGen = cont.getMejorGen();
        double[] mejorAbs = cont.getMejorAbs();
        double[] mediaGen = cont.getMediaGen();

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();

        // define the legend position
        plot.addLegend("SOUTH");

        // add a line plot to the PlotPanel
        //plot.addLinePlot("my plot", x, y/*numGen, mejorGen*/);

        plot.addLinePlot("Mejor Absoluto", numGen, mejorAbs);
        plot.addLinePlot("Mejor Generacion", numGen, mejorGen);
        plot.addLinePlot("Media Generacion", numGen, mediaGen);

        // put the PlotPanel in a JFrame like a JPanel

        plot.setSize(600, 600);
        this.add(plot, BorderLayout.CENTER);
    }
}
