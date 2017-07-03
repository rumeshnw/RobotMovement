package au.com.robotMovement.service;

import au.com.robotMovement.domain.Coordinates;
import au.com.robotMovement.domain.Robot;
import au.com.robotMovement.domain.Table;
import au.com.robotMovement.enums.Action;
import au.com.robotMovement.enums.Direction;
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
    public void positionRobot(int xCoordinate, int yCoordinate, Direction direction) {

        Robot robot = table.getRobotInstance();
        if(table.isValidPosition(xCoordinate, yCoordinate)){
            Coordinates coordinates = robot.getCoordinatesInstance();
            coordinates.setXCoordinate(xCoordinate);
            coordinates.setYCoordinate(yCoordinate);
            coordinates.setDirection(direction);
        }
    }

    @Override
    public void performAction(Action action) {
        if(RobotAction.continueAction(table.getRobot())){
            switch (action){
                case LEFT:
                    RobotAction.turnLeft().performAction(table.getRobot());
                    break;
                case RIGHT:
                    RobotAction.turnRight().performAction(table.getRobot());
                    break;
                case MOVE:
                    RobotAction.moveRobot(table).performAction(table.getRobot());
                    break;
            }
        }
    }

    @Override
    public Optional<String> report() {
        return table.getRobot() != null ? Optional.of(table.getRobot().toString()) : Optional.empty();
    }
}
