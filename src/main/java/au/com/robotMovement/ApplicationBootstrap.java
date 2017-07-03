package au.com.robotMovement;

import au.com.robotMovement.config.ResourceFactory;
import au.com.robotMovement.ui.Console;

/**
 * Bootstrap class to start the application
 *
 * @author rnadeera
 */
public class ApplicationBootstrap {

    public static void main(String[] args){
        Console console = ResourceFactory.console();
        console.startConsole();
    }
}
