package au.com.robotMovement.config;

import au.com.robotMovement.domain.Table;
import au.com.robotMovement.service.RobotMovementService;
import au.com.robotMovement.service.RobotMovementServiceImpl;
import au.com.robotMovement.ui.Console;
import au.com.robotMovement.ui.ConsoleImpl;
import au.com.robotMovement.ui.handler.ExceptionHandler;
import au.com.robotMovement.ui.handler.ExceptionHandlerImpl;

/**
 * Factory to create instance of resources across application
 *
 * @author rnadeera
 */
public class ResourceFactory {

    private ResourceFactory(){

    }

    public static Console console(){
        ConsoleImpl console = new ConsoleImpl();
        console.setExceptionHandler(getExceptionHandler());
        console.setRobotMovementService(robotMovementService());
        return console;
    }

    public static RobotMovementService robotMovementService(){
        return new RobotMovementServiceImpl(squareTable());
    }


    public static Table squareTable(){
        return Table.buildSquareTable(5);
    }

    public static ExceptionHandler getExceptionHandler(){
        return new ExceptionHandlerImpl();
    }
}
