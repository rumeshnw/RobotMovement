package au.com.robotMovement.service;

import au.com.robotMovement.domain.Coordinates;
import au.com.robotMovement.domain.Robot;
import au.com.robotMovement.domain.Table;
import au.com.robotMovement.enums.Action;
import au.com.robotMovement.enums.Facing;
import au.com.robotMovement.service.process.RobotAction;

import java.util.Optional;

/**
 * @See {@link RobotMovementService}
 * @author rnadeera
 */
public class RobotMovementServiceImpl implements RobotMovementService {

    private Table table;

    public RobotMovementServiceImpl(Table table){
        this.table = table;
    }

    @Override
    public Robot positionRobot(int xCoordinate, int yCoordinate, Facing facing) {

        Robot robot = table.getRobotInstance();
        if(table.isValidPosition(xCoordinate, yCoordinate)){
            Coordinates coordinates = robot.getCoordinatesInstance();
            coordinates.setXCoordinate(xCoordinate);
            coordinates.setYCoordinate(yCoordinate);
            coordinates.setFacing(facing);
        }

        return robot;
    }

    @Override
    public void performAction(Action action) {
        switch (action){
            case LEFT:
                RobotAction.turnLeft().performAction(table.getRobot());
                break;
            case RIGHT:
                RobotAction.turnRight().performAction(table.getRobot());
                break;
            case MOVE:
                RobotAction.moveRobot().performAction(table.getRobot());
                break;
        }
    }

    @Override
    public Optional<String> report() {
        return table.getRobot() != null ? Optional.of(table.getRobot().toString()) : Optional.empty();
    }
}
