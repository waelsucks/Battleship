package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.GameController;

import java.awt.*;

public class RightPanel extends JPanel {

    JList<String> scoreBoard;
    JLabel lastHit;
    JLabel hitsLeft;
    private GameController controller;

    public RightPanel() {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        setLastHit(new JLabel());
        add(getLastHit());

        JLabel title = new JLabel("SCOREBOARD");
        add(title, BorderLayout.NORTH);

        hitsLeft = new JLabel();
        add(hitsLeft);

        scoreBoard = new JList<>();
        scoreBoard.setSize(getWidth(), 400);
        add(scoreBoard);

        JButton newGame = new JButton("Start new game");
        newGame.addActionListener(e -> getController().startNewGame());
        add(newGame);

        setVisible(true);

    }

    public GameController getController() {
        return this.controller;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public JLabel getHitsLeft() {
        return this.hitsLeft;
    }

    public void setHitsLeft(JLabel hitsLeft) {
        this.hitsLeft = hitsLeft;
    }

    public void shipHit(String ship) {
        getLastHit().setText("You just hit: " + ship);
    }

    public JList<String> getScoreBoard() {
        return this.scoreBoard;
    }

    public void setScoreBoard(JList<String> scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public JLabel getLastHit() {
        return this.lastHit;
    }

    public void setLastHit(JLabel lastHit) {
        this.lastHit = lastHit;
    }

}
