package au.com.robotMovement.config;

import au.com.robotMovement.domain.Table;
import au.com.robotMovement.service.RobotMovementService;
import au.com.robotMovement.service.RobotMovementServiceImpl;
import au.com.robotMovement.ui.Console;
import au.com.robotMovement.ui.ConsoleImpl;

/**
 * Factory to create instance of resources across application
 *
 * @author rnadeera
 */
public class ResourceFactory {

    private ResourceFactory(){

    }

    public static Console console(){
        return new ConsoleImpl(robotMovementService());
    }

    public static RobotMovementService robotMovementService(){
        return new RobotMovementServiceImpl(squareTable());
    }


    public static Table squareTable(){
        return Table.buildSquareTable(5);
    }
}
