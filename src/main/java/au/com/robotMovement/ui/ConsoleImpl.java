package au.com.robotMovement.ui;

import au.com.robotMovement.enums.Action;
import au.com.robotMovement.enums.Facing;
import au.com.robotMovement.service.RobotMovementService;

/**
 * @author rnadeera
 * @See Console
 */
public class ConsoleImpl implements Console {

    RobotMovementService robotMovementService;

    public ConsoleImpl(RobotMovementService robotMovementService){
        this.robotMovementService = robotMovementService;
    }

    @Override
    public void startConsole() {
        showBanner();

        //TODO: Remove after testing
        robotMovementService.positionRobot(1, 2, Facing.EAST);
        robotMovementService.performAction(Action.MOVE);
        robotMovementService.performAction(Action.MOVE);
        robotMovementService.performAction(Action.LEFT);
        robotMovementService.performAction(Action.MOVE);
        robotMovementService.report().ifPresent(System.out::println);

//        withScanner(scanner -> {
//
//        });
    }

    private void showBanner(){
        System.out.println("##################################################################");
        System.out.println("################## Welcome to Robot Movement #####################");
        System.out.println("##################################################################");
    }

}
