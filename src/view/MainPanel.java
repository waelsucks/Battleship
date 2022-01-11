package view;

import javax.swing.*;

import controller.GameController;

import java.awt.*;

public class MainPanel extends JPanel {

    private int rows;
    private int columns;
    private GameController controller;

    public MainPanel(GameController controller) {

        setController(controller);

        setRows(getController().getModel().getRows());
        setColumns(getController().getModel().getColumns());

        setLayout(new GridLayout(getRows(), getColumns()));

        spawnButtons();

    }

    private void handleClick(int x, int y, JButton button) {

        boolean hit = getController().handleClick(x, y);
        button.setEnabled(false);

        if (hit) {
            button.setBackground(Color.GREEN);
        } else {
            button.setBackground(Color.RED);
        }

    }

    public void spawnButtons() {

        removeAll();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                int x = i;
                int y = j;

                JButton coordinate = new JButton();
                coordinate.addActionListener(e -> handleClick(x, y, coordinate));
                add(coordinate);

            }
        }

    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public GameController getController() {
        return this.controller;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

}
