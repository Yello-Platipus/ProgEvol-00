package View;

import Controller.Controller;
import Cositas.AlgoritmoGenetico;
import View.ConfigPanel.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    Controller cont;
    ConfigPanel cPanel;
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
        cPanel.addOption(new IntegerOption<AlgoritmoGenetico>(
                "Poblacion", "Numero de individuos en la poblacion",
                "tamPoblacion", 1, Integer.MAX_VALUE));

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(cPanel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
}
