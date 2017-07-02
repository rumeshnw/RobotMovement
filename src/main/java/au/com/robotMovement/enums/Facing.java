package au.com.robotMovement.enums;

/**
 * enum holds direction {@link au.com.robotMovement.domain.Robot} currently facing
 *
 * @author rnadeera
 */
public enum Facing {
    NORTH(0, 1, "WEST", "EAST"),
    SOUTH(0, -1, "EAST", "WEST"),
    EAST(1, 0, "NORTH", "SOUTH"),
    WEST(-1, 0, "SOUTH", "NORTH");

    private int nextMoveXCoordinateChange;
    private int nextMoveYCoordinateChange;
    private String turnLeft;
    private String turnRight;

    Facing(int nextMoveXCoordinateChange, int nextMoveYCoordinateChange, String turnLeft, String turnRight) {
        this.nextMoveXCoordinateChange  = nextMoveXCoordinateChange;
        this.nextMoveYCoordinateChange  = nextMoveYCoordinateChange;
        this.turnLeft                   = turnLeft;
        this.turnRight                  = turnRight;
    }

    public int getNextMoveXCoordinateChange() {
        return nextMoveXCoordinateChange;
    }

    public int getNextMoveYCoordinateChange() {
        return nextMoveYCoordinateChange;
    }

    public Facing getTurnLeft() {
        return Facing.valueOf(turnLeft);
    }

    public Facing getTurnRight() {
        return Facing.valueOf(turnRight);
    }
}
