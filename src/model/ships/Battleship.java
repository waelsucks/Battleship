package model.ships;

public class Battleship extends Ship{
    public Battleship() {
        setLength(5);
        setHealth(getLength());
        setType(ShipTypes.BATTLESHIP);
    }
}
