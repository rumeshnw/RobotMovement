package au.com.robotMovement.service.process;

import au.com.robotMovement.domain.Coordinates;
import au.com.robotMovement.domain.Robot;
import au.com.robotMovement.domain.Table;

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
     * @param table
     */
    static RobotAction moveRobot(Table table){
        return robot -> {
            Coordinates currentCoordinates = robot.getCoordinates();

            int newXCoordinate = currentCoordinates.getXCoordinateOnNextMove();
            int newYCoordinate = currentCoordinates.getYCoordinateOnNextMove();

            if(table.isValidPosition(newXCoordinate, newYCoordinate)){
                currentCoordinates.setXCoordinate(newXCoordinate);
                currentCoordinates.setYCoordinate(newYCoordinate);
            }
        };
    }

    /**
     * @return Concrete {@link RobotAction} to handle turn {@link au.com.robotMovement.domain.Robot} to left
     */
    static RobotAction turnLeft(){
        return robot -> robot.getCoordinates().setDirection(robot.getCoordinates().getDirection().getDirectionLeft());
    }

    /**
     * @return Concrete {@link RobotAction} to handle turn {@link au.com.robotMovement.domain.Robot} to right
     */
    static RobotAction turnRight(){
        return robot -> robot.getCoordinates().setDirection(robot.getCoordinates().getDirection().getDirectionRight());
    }
}
