package au.com.robotMovement

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import spock.lang.Specification
import spock.lang.Stepwise

/**
 * @author randeera
 */
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationBootstrap.class)
@Stepwise
class BaseIntegrationSpec extends Specification {

    @Autowired
    ApplicationContext applicationContext

    def "Should boot application without any errors"(){
        expect:
        applicationContext
    }
}
