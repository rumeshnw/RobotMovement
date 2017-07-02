package au.com.robotMovement.service;

import au.com.robotMovement.domain.Robot;
import au.com.robotMovement.enums.Action;
import au.com.robotMovement.enums.Facing;

import java.util.Optional;

/**
 * Service to handle all Robot Movement functionality
 *
 * @author rnadeera
 */
public interface RobotMovementService {

    Robot positionRobot(int xCoordinate, int yCoordinate, Facing facing);

    void performAction(Action action);

    Optional<String> report();
}
