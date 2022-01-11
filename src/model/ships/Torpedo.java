package model.ships;

public class Torpedo extends Ship {
    
    public Torpedo() {

        setLength(2);
        setHealth(getLength());
        setType(ShipTypes.TORPEDO);

    }

}
