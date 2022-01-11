package model.ships;

public class Submarine extends Ship {
    
    public Submarine() {

        setLength(1);
        setHealth(getLength());
        setType(ShipTypes.SUBMARINE);

    }

}
