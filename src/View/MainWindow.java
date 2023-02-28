package View;

import Controller.Controller;
import Cositas.AlgoritmoGenetico;
import Cositas.Seleccion.Seleccion;
import Cositas.Seleccion.SeleccionRuleta;
import View.ConfigPanel.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    Controller cont;
    ConfigPanel cPanel;
    AlgoritmoGenetico ag;

    public MainWindow(Controller cont){
        super("Panel de configuracion");
        cPanel = new ConfigPanel<AlgoritmoGenetico>();
        this.cont = cont;
        init();
        cPanel.setTarget(cont.getAG());
        cPanel.initialize();
    }
    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        iniPanel();
        iniGrafica();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(cPanel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
}
