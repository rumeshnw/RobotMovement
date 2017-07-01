package au.com.robotMovement;

import au.com.robotMovement.config.AppConfig;
import au.com.robotMovement.ui.Console;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bootstrap class to start the application
 *
 * @author rnadeera
 */
public class ApplicationBootstrap {

    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Console console = ctx.getBean(Console.class);
        console.startConsole();
    }
}
