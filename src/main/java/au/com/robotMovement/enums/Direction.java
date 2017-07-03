package au.com.robotMovement.enums;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * enum holds direction {@link au.com.robotMovement.domain.Robot} currently facing
 *
 * @author rnadeera
 */
public enum Direction {
    NORTH(0, 1, "WEST", "EAST"),
    SOUTH(0, -1, "EAST", "WEST"),
    EAST(1, 0, "NORTH", "SOUTH"),
    WEST(-1, 0, "SOUTH", "NORTH");

    private int nextMoveXCoordinateChange;
    private int nextMoveYCoordinateChange;

    private String directionLeft;
    private String directionRight;

    Direction(int nextMoveXCoordinateChange, int nextMoveYCoordinateChange, String directionLeft, String directionRight) {
        this.nextMoveXCoordinateChange  = nextMoveXCoordinateChange;
        this.nextMoveYCoordinateChange  = nextMoveYCoordinateChange;
        this.directionLeft              = directionLeft;
        this.directionRight             = directionRight;
    }

    public static String getAllDirectionAsString(){
        return Stream.of(Direction.values()).map(direction -> direction.toString())
                                            .collect(Collectors.joining("|"));
    }

    public int getNextMoveXCoordinateChange() {
        return nextMoveXCoordinateChange;
    }

    public int getNextMoveYCoordinateChange() {
        return nextMoveYCoordinateChange;
    }

    public Direction getDirectionLeft() {
        return Direction.valueOf(directionLeft);
    }

    public Direction getDirectionRight() {
        return Direction.valueOf(directionRight);
    }
}
