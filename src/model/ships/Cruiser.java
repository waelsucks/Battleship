package model.ships;

public class Cruiser extends Ship{

    public Cruiser() {
        setLength(3);
        setHealth(getLength());
        setType(ShipTypes.CRUISER);
    }
    
}
