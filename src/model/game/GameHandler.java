package model.game;

import java.util.ArrayList;
import java.util.Collections;

public class GameHandler {

    private ArrayList<Game> gamesPlayed;
    private String[] scoreBoard;

    public GameHandler() {

        setGamesPlayed(new ArrayList<Game>());
        setScoreBoard(new String[10]);

    }

    public boolean addGame(Game game) {

        // Adds game to history and checks if that user had a highscore.

        getGamesPlayed().add(game);
        Collections.sort(gamesPlayed);

        for (int i = 0; i < gamesPlayed.size(); i++) {
            
            scoreBoard[i] = gamesPlayed.get(i).toString();

        }

        for (int i = 0; i < scoreBoard.length; i++) {
            if (game == gamesPlayed.get(i) && i < 10) {
                return true;
            }
        }

        return false;

    }

    public ArrayList<Game> getGamesPlayed() {
        return this.gamesPlayed;
    }

    public void setGamesPlayed(ArrayList<Game> gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String[] getScoreBoard() {
        return this.scoreBoard;
    }

    public void setScoreBoard(String[] scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

}
