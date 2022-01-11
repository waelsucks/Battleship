package model.ships;

public abstract class Ship {

    private ShipTypes type;
    private int length;
    private int[][] location;
    private int health;

    public int damage() {
        health --;
        return getHealth();
    }

    public ShipTypes getType() {
        return this.type;
    }

    public void setType(ShipTypes type) {
        this.type = type;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[][] getLocation() {
        return this.location;
    }

    public void setLocation(int[][] location) {
        this.location = location;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
