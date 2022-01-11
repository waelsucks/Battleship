package view;

import javax.swing.*;
import java.awt.*;

import controller.GameController;

public class MainFrame extends JFrame {

    private GameController controller;
    private MainPanel mainPanel;
    private RightPanel rightPanel;

    public MainFrame(GameController controller) {

        super("Battleship!");

        setController(controller);

        setSize(800, 600);
        setResizable(false);

        setLayout(new BorderLayout());

        setMainPanel(new MainPanel(getController()));
        add(getMainPanel(), BorderLayout.CENTER);

        setRightPanel(new RightPanel());
        add(getRightPanel(), BorderLayout.EAST);
        getRightPanel().setController(controller);

        setVisible(true);

    }

    public GameController getController() {
        return this.controller;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public MainPanel getMainPanel() {
        return this.mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public String getUserName() {

        return new JOptionPane().showInputDialog("Game over! Please enter your name.");

    }

    public void displayMesage(String format) {
        new JOptionPane().showMessageDialog(this, format);
    }

    public RightPanel getRightPanel() {
        return this.rightPanel;
    }

    public void setRightPanel(RightPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

}
