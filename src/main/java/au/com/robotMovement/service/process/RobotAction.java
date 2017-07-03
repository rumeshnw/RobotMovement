package au.com.robotMovement.service.process;

import au.com.robotMovement.domain.Coordinates;
import au.com.robotMovement.domain.Robot;

/**
 *  Interface for Robot Actions
 *
 * @author rnadeera
 */
@FunctionalInterface
public interface RobotAction {

    void performAction(Robot robot);

    /**
     * Check given {@link Robot} instance is valid to perform any action
     *
     * @param robot {@link Robot} instance
     * @return boolean
     */
    static boolean continueAction(Robot robot){
        return robot != null && robot.isRobotPlacedOnTable();
    }

    /**
     * @return Concrete {@link RobotAction} to handle {@link au.com.robotMovement.domain.Robot} to move
     */
    static RobotAction moveRobot(){
        return robot -> {
            if(continueAction(robot)){
                Coordinates coordinates = robot.getCoordinates();
                int newXCoordinate = coordinates.getXCoordinate() + coordinates.getFacing().getNextMoveXCoordinateChange();
                int newYCoordinate = coordinates.getYCoordinate() + coordinates.getFacing().getNextMoveYCoordinateChange();

                if(robot.getTable().isValidPosition(newXCoordinate, newYCoordinate)){
                    coordinates.setXCoordinate(newXCoordinate);
                    coordinates.setYCoordinate(newYCoordinate);
                }
            }
        };
    }

    /**
     * @return Concrete {@link RobotAction} to handle turn {@link au.com.robotMovement.domain.Robot} to left
     */
    static RobotAction turnLeft(){
        return robot -> {
            if(continueAction(robot)){
                robot.getCoordinates().setFacing(robot.getCoordinates().getFacing().getTurnLeft());
            }
        };
    }

    /**
     * @return Concrete {@link RobotAction} to handle turn {@link au.com.robotMovement.domain.Robot} to right
     */
    static RobotAction turnRight(){
        return robot -> {
            if(continueAction(robot)){
                robot.getCoordinates().setFacing(robot.getCoordinates().getFacing().getTurnRight());
            }
        };
    }
}
