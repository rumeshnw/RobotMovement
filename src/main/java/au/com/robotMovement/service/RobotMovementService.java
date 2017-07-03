package au.com.robotMovement.service;

import au.com.robotMovement.enums.Action;
import au.com.robotMovement.enums.Direction;

import java.util.Optional;

/**
 * Service to handle all Robot Movement functionality
 *
 * @author rnadeera
 */
public interface RobotMovementService {

    void positionRobot(int xCoordinate, int yCoordinate, Direction direction);

    void performAction(Action action);

    Optional<String> report();
}
