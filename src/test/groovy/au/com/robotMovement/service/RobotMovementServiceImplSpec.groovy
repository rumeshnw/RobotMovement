package au.com.robotMovement.service

import au.com.robotMovement.config.ResourceFactory
import au.com.robotMovement.domain.Table
import au.com.robotMovement.enums.Direction
import spock.lang.Specification

/**
 * @author rnadeera
 */
class RobotMovementServiceImplSpec extends Specification {

    RobotMovementServiceImpl robotMovementService

    def setup(){
        robotMovementService = ResourceFactory.robotMovementService()
    }

    def "test positionRobot, should not set robot on the table when given coordinates are not valid"(){
        expect:
        !robotMovementService.table.robot
        !robotMovementService.table.robot?.coordinates

        when:
        robotMovementService.positionRobot(6, 3, Direction.WEST)

        then:
        !robotMovementService.table.robot
        !robotMovementService.table.robot?.coordinates
    }

    def "test positionRobot, should set robot on the table when given coordinates are valid"(){
        expect:
        !robotMovementService.table.robot
        !robotMovementService.table.robot?.coordinates

        when:
        robotMovementService.positionRobot(2, 3, Direction.WEST)

        then:
        robotMovementService.table.robot
        robotMovementService.table.robot.coordinates

        and:
        robotMovementService.table.robot.coordinates.xCoordinate    == 2
        robotMovementService.table.robot.coordinates.yCoordinate    == 3
        robotMovementService.table.robot.coordinates.direction      == Direction.WEST
    }

    def "test report, should return empty optional String when robot is not placed on table"(){
        when:
        Optional<String> report = robotMovementService.report()

        then:
        !report.isPresent()
    }
}
