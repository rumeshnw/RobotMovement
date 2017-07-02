package au.com.robotMovement.config;

import au.com.robotMovement.domain.Table;
import au.com.robotMovement.service.RobotMovementService;
import au.com.robotMovement.service.RobotMovementServiceImpl;
import au.com.robotMovement.ui.Console;
import au.com.robotMovement.ui.ConsoleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rnadeera
 */
@Configuration
public class AppConfig {

    @Bean
    public Console console(){
        return new ConsoleImpl();
    }

    @Bean
    public RobotMovementService robotMovementService(){
        return new RobotMovementServiceImpl();
    }

    @Bean
    public Table table(){
        return Table.buildSquareTableTop(5);
    }
}
