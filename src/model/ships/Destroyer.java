package model.ships;

public class Destroyer extends Ship {

    public Destroyer() {
        setLength(4);
        setHealth(getLength());
        setType(ShipTypes.DESTROYER);
    }

}
