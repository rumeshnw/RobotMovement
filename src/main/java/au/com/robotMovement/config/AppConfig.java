package au.com.robotMovement.config;

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

    //TODO specify other beans
}
