package au.com.robotMovement.domain;

import au.com.robotMovement.enums.Facing;

/**
 * Hold Coordinates information
 * @author rnadeera
 */
public class Coordinates {

    private int xCoordinate;
    private int yCoordinate;
    private Facing facing;

    public Coordinates(int xCoordinate, int yCoordinate, Facing facing) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.facing = facing;
    }

    public Coordinates() {
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    @Override
    public String toString() {
        return xCoordinate + ", " + yCoordinate + ", " + facing.toString();
    }
}
