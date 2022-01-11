package model.game;

import java.util.Arrays;

import controller.GameController;
import model.ships.Battleship;
import model.ships.Cruiser;
import model.ships.Destroyer;
import model.ships.Ship;
import model.ships.ShipTypes;
import model.ships.Submarine;
import model.ships.Torpedo;

public class Game implements Comparable {

    private int score;
    private int rows;
    private int columns;

    private Ship[] ships;
    private int shipsCount;

    private String userName;

    private Ship lastHit;

    private GameController controller;

    public Game(int rows, int columns, GameController controller) {

        setController(controller);

        setRows(rows);
        setColumns(columns);
        setScore(getRows() * getColumns());

        setShips(new Ship[5]);

        spawnShips();

        System.out.println("Started new game.");

    }

    private void spawnShips() {

        // Spawns default ships to map.

        addShip(ShipTypes.SUBMARINE, 1, 1, 0);
        addShip(ShipTypes.TORPEDO, 2, 2, 1);
        addShip(ShipTypes.CRUISER, 8, 8, 1);
        addShip(ShipTypes.BATTLESHIP, 0, 0, 0);
        addShip(ShipTypes.DESTROYER, 9, 9, 1);

    }

    public Ship addShip(ShipTypes type, int x, int y, int angle) {

        // Adds ship to array and returns created ship.
        // Angle:
        // 0: Horizontal
        // 1: Vertical

        Ship ship = null;

        if (x < 0 || x > getColumns() || y < 0 || y > getRows()) {
            getController().getView().displayMesage("Tried setting ship out of bounds.");
            return null;
        }

        switch (type) {

            case TORPEDO:
                ship = new Torpedo();
                break;

            case SUBMARINE:
                ship = new Submarine();
                break;
            case DESTROYER:
                ship = new Destroyer();
                break;
            case CRUISER:
                ship = new Cruiser();
                break;
            case BATTLESHIP:
                ship = new Battleship();
                break;

            default:
                break;
        }

        ship.setLocation(new int[ship.getLength()][]); // Sets startpoint of ship.

        for (int i = 0; i < ship.getLength(); i++) {

            if (angle == 0) { // Horizontal

                ship.getLocation()[i] = new int[] {
                        x + i, y
                };

            } else {

                ship.getLocation()[i] = new int[] {
                        x, y + i
                };

            }

        }

        for (int[] coord : ship.getLocation()) {

            // Checking if out of bounds or another ship is there.

            if (coord[0] < 0 || coord[0] >= getColumns()) {
                System.out.println(String.format("%s ship x-pos is out of bounds.", ship.getType()));
                return null;
            }

            if (coord[1] < 0 || coord[1] >= getRows()) {
                System.out.println(String.format("%s ship y-pos is out of bounds.", ship.getType()));
                return null;
            }

            for (Ship otherShip : getShips()) {

                if (ship == otherShip || otherShip == null) {
                    continue;
                }

                for (int[] coordOther : otherShip.getLocation()) {

                    if (Arrays.equals(coord, coordOther)) {

                        System.out.println(String.format("%s ship same coord as %s.", ship.getType(), otherShip.getType()));
                        return null;
                    }

                }

            }

        }

        ships[shipsCount] = ship;
        shipsCount++;

        return ship;

    }

    public GameController getController() {
        return this.controller;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public Ship getLastHit() {
        return this.lastHit;
    }

    public void setLastHit(Ship lastHit) {
        this.lastHit = lastHit;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getShipsCount() {
        return this.shipsCount;
    }

    public void setShipsCount(int shipsCount) {
        this.shipsCount = shipsCount;
    }

    public Ship[] getShips() {
        return this.ships;
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public boolean hit(int x, int y) {

        // Change to function that can detect if ship is there. Damage another
        // functions.

        int[] hit = { x, y };

        for (Ship ship : ships) {

            if (ship == null) {
                continue;
            }

            for (int[] location : ship.getLocation()) {

                if (Arrays.equals(hit, location)) {

                    // We have a hit!

                    setLastHit(ship);

                    ship.damage();

                    if (ship.getHealth() == 0) {
                        shipsCount--;
                    }

                    return true;
                }

            }
        }

        // If not a hit...

        setScore(score - 1);

        return false;

    }

    @Override
    public int compareTo(Object o) {

        int comparage = ((Game) o).getScore();
        return comparage - this.getScore();

    }

    @Override
    public String toString() {
        return String.format("Name: %s Score: %s", getUserName(), getScore());
    }

}
