package au.com.robotMovement.ui

import au.com.robotMovement.BaseIntegrationSpec
import au.com.robotMovement.config.ResourceFactory
import au.com.robotMovement.enums.Direction
import au.com.robotMovement.service.RobotMovementService

/**
 * @author rnadeera
 */
class ConsoleImplIntegrationSpec extends BaseIntegrationSpec {

    ConsoleImpl console

    def setup(){
        console = ResourceFactory.console()
    }

    def "test placeRobot, should place the robot on the table when PLACE command is entered with valid coordinates"(){
        when:
        console.placeRobot("PLACE 0,1,NORTH")

        then:
        notThrown(IllegalArgumentException)

        and:
        console.robotMovementService.report().get() == "0, 1, NORTH"
    }
}
