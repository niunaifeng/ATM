 import java.awt.*;import java.applet.Applet;import atm.ATM;import simulation.Simulation; public class ATMApplet extends Applet{    public void init()    {                        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",                             null);        Simulation theSimulation = new Simulation(theATM);                                new Thread(theATM).start();                               Panel gui = theSimulation.getGUI();        setBackground(gui.getBackground());        add(gui);    }}    