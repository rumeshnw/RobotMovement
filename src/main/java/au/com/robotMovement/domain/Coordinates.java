package au.com.robotMovement.domain;

import au.com.robotMovement.enums.Direction;

/**
 * Hold Coordinates information
 * @author rnadeera
 */
public class Coordinates {

    private int xCoordinate;
    private int yCoordinate;
    private Direction direction;

    public Coordinates(int xCoordinate, int yCoordinate, Direction direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getXCoordinateOnNextMove(){
        return xCoordinate + direction.getNextMoveXCoordinateChange();
    }

    public int getYCoordinateOnNextMove(){
        return yCoordinate + direction.getNextMoveYCoordinateChange();
    }

    @Override
    public String toString() {
        return xCoordinate + ", " + yCoordinate + ", " + direction.toString();
    }
}
