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

    public static Table table(){
        return Table.buildSquareTableTop(5);
    }

    public static RobotMovementService robotMovementService(){
        return new RobotMovementServiceImpl(table());
    }

    public static Console console(){
        return new ConsoleImpl(robotMovementService());
    }
}
