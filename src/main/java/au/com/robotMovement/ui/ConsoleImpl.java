package au.com.robotMovement.ui;

import au.com.robotMovement.enums.Command;
import au.com.robotMovement.enums.Direction;
import au.com.robotMovement.service.RobotMovementService;
import au.com.robotMovement.ui.handler.ExceptionHandler;

import java.util.regex.Pattern;

/**
 * @author rnadeera
 * @See Console
 */
public class ConsoleImpl implements Console {

    private static final Pattern PLACE_PATTERN = Pattern.compile("("+ Command.PLACE.toString() +")\\s\\d{1,2},\\d{1,2},("+ Direction.getAllDirectionAsString() +")");

    private RobotMovementService robotMovementService;
    private ExceptionHandler exceptionHandler;

    public void setRobotMovementService(RobotMovementService robotMovementService) {
        this.robotMovementService = robotMovementService;
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void startConsole() {
        showBanner();
        System.out.println("Enter any of the following command to begin robot movement\n");
        showAllCommands();

        withScanner(scanner -> {
            Command command = null;
            do {
                try {
                    String userInput    = trimUserInput(scanner);
                    command             = getCommand(userInput);

                    switch (command){
                        case PLACE:
                            placeRobot(userInput);
                            break;
                        case MOVE:case RIGHT:case LEFT:
                            robotMovementService.performAction(command);
                            break;
                        case REPORT:
                            robotMovementService.report().ifPresent(System.out::println);
                            break;
                        case EXIT:
                            System.out.println("See you soon. Have a nice day!!!");
                            break;
                        default:
                            System.out.println("Invalid command. Please try again with a valid command.");
                            showAllCommands();
                            break;
                    }

                } catch(Exception e){
                    System.out.println(exceptionHandler.handle(e));
                }
            } while(command != Command.EXIT);
        });
    }

    private void showBanner(){
        System.out.println("##################################################################");
        System.out.println("################## Welcome to Robot Movement #####################");
        System.out.println("##################################################################");
    }

    private void showAllCommands(){
        System.out.println("PLACE X,Y,F [X --> X coordinate, Y --> Y coordinate & F --> Facing direction]");
        System.out.println("MOVE");
        System.out.println("LEFT");
        System.out.println("RIGHT");
        System.out.println("REPORT");
        System.out.println("EXIT");
    }

    private Command getCommand(String userInput){
        try {
            return Command.valueOf(userInput.split("\\s")[0]);
        } catch (Exception e){
            throw new IllegalArgumentException("Invalid command. Please try again with a valid command.");
        }
    }

    private void placeRobot(String userInput){
        if(!PLACE_PATTERN.matcher(userInput).matches()){
            throw new IllegalArgumentException("Format of the PLACE command is invalid. Valid command should be PLACE X,Y,F where X is X coordinate, Y is Y coordinate and F is Facing direction(NORTH,SOUTH,EAST,WEST)");
        }

        String[] directionInputs = getPlacementCoordinates(userInput);

        robotMovementService.positionRobot(Integer.parseInt(directionInputs[0]), Integer.parseInt(directionInputs[1]), Direction.valueOf(directionInputs[2]));
    }

    private String[] getPlacementCoordinates(String userInput){
        return (userInput.split("\\s")[1]).split(",");
    }

}
