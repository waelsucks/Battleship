package controller;

import javax.swing.JList;

import model.game.Game;
import model.game.GameHandler;
import model.ships.Ship;
import view.MainFrame;

public class GameController {

    private MainFrame view;
    private GameHandler history;
    private Game model;

    public GameController() {

        model = new Game(10, 10, this);
        view = new MainFrame(this);
        history = new GameHandler();

    }

    public MainFrame getView() {
        return this.view;
    }

    public void setView(MainFrame view) {
        this.view = view;
    }

    public Game getModel() {
        return this.model;
    }

    public void setModel(Game model) {
        this.model = model;
    }

    public boolean handleClick(int x, int y) {

        boolean isHit = model.hit(x, y);

        int hitsLeft = 0;

        for (Ship ship : getModel().getShips()) {
            if (ship == null) {
                continue;
            }

            hitsLeft += ship.getHealth();

        }

        getView().getRightPanel().getHitsLeft().setText("HITS LEFT: " + hitsLeft);

        // Check if game is over.

        if (isHit) {

            int shipsLeft = getModel().getShipsCount();

            getView().getRightPanel().shipHit(getModel().getLastHit().getType().toString());

            if (getModel().getLastHit().getHealth() == 0) {

                // If ship died.

                getView().displayMesage("You just sunk their: " + getModel().getLastHit().getType().toString());

            }

            // If game is over.

            if (shipsLeft == 0) {

                System.out.println("Game over!");

                String playerName = getView().getUserName();
                getModel().setUserName(playerName);

                boolean highScore = getHistory().addGame(getModel());

                if (highScore) {
                    getView().displayMesage(
                            String.format("Congratulations! You had a highscore of %s", getModel().getScore()));
                }

                // Restart

                setModel(new Game(10, 10, this));
                getView().getMainPanel().spawnButtons();
                getView().getRightPanel().getScoreBoard().setListData(getHistory().getScoreBoard());

            }

        }

        return isHit;

    }

    public GameHandler getHistory() {
        return this.history;
    }

    public void setHistory(GameHandler history) {
        this.history = history;
    }

    public void startNewGame() {

        setModel(new Game(10, 10, this));

        int hitsLeft = 0;

        for (Ship ship : getModel().getShips()) {
            if (ship == null) {
                continue;
            }

            hitsLeft += ship.getHealth();

        }

        getView().getRightPanel().getHitsLeft().setText("HITS LEFT:" + hitsLeft);
        getView().getMainPanel().spawnButtons();
        getView().getRightPanel().getScoreBoard().setListData(getHistory().getScoreBoard());

        getView().displayMesage("Started a new game!");

    }

}
