package au.com.robotMovement.domain

import au.com.robotMovement.enums.Direction
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author rnadeera
 */
class RobotSpec extends Specification {

    @Unroll
    def "test isRobotPlacedOnTable, should return #response when coordinates is #coordinates and direction is #direction"(){
        given:
        Robot newRobot                  = new Robot()
        newRobot.coordinates            = coordinates
        newRobot.coordinates?.direction = direction

        when:
        boolean isOnTable = newRobot?.isRobotPlacedOnTable()

        then:
        isOnTable == response

        where:
        coordinates       | direction       | response
        new Coordinates() | null            | false
        null              | Direction.WEST  | false
        new Coordinates() | Direction.WEST  | true
    }

    def "test getCoordinatesInstance, should return new Coordinates instance when coordinates is null on Robot instance"(){
        given:
        Robot robot = new Robot()

        expect:
        !robot.coordinates

        when:
        Coordinates coordinates  = robot.getCoordinatesInstance()

        then:
        coordinates
        robot.coordinates

        coordinates == robot.coordinates
    }
}
