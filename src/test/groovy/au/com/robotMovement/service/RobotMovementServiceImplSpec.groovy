package au.com.robotMovement.service

import au.com.robotMovement.config.ResourceFactory
import au.com.robotMovement.domain.Coordinates
import au.com.robotMovement.domain.Robot
import au.com.robotMovement.enums.Command
import au.com.robotMovement.enums.Direction
import spock.lang.Specification
import spock.lang.Unroll

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

    def "test report, should return optional String with a value when robot is placed on table"(){
        given:
        placeRobotInTable()

        when:
        Optional<String> report = robotMovementService.report()

        then:
        report.isPresent()

        and:
        report.get() == "0, 0, NORTH"
    }

    def "test performAction, should turn robot to left in the current position when command is LEFT"(){
        given:
        placeRobotInTable()

        when:
        robotMovementService.performAction(Command.LEFT)

        then:
        Coordinates coordinates = robotMovementService.table.robot.coordinates

        and:
        coordinates.xCoordinate == 0
        coordinates.yCoordinate == 0
        coordinates.direction   == Direction.WEST
    }

    def "test performAction, should turn robot to right in the current position when command is RIGHT"(){
        given:
        placeRobotInTable()

        when:
        robotMovementService.performAction(Command.RIGHT)

        then:
        Coordinates coordinates = robotMovementService.table.robot.coordinates

        and:
        coordinates.xCoordinate == 0
        coordinates.yCoordinate == 0
        coordinates.direction   == Direction.EAST
    }

    @Unroll
    def "test performAction, should change position by one unit from the current position when command is MOVE"(){
        given:
        placeRobotInTable(currentXCoordinate, currentYCoordinate, currentDirection)

        when:
        robotMovementService.performAction(Command.MOVE)

        then:
        Coordinates coordinates = robotMovementService.table.robot.coordinates

        and:
        coordinates.xCoordinate == newXCoordinate
        coordinates.yCoordinate == newYCoordinate
        coordinates.direction   == currentDirection

        where:
        currentXCoordinate  | currentYCoordinate    | currentDirection  | newXCoordinate    | newYCoordinate
        0                   | 0                     | Direction.NORTH   | 0                 | 1
        0                   | 0                     | Direction.SOUTH   | 0                 | 0
        2                   | 1                     | Direction.SOUTH   | 2                 | 0
        3                   | 4                     | Direction.EAST    | 4                 | 4
        1                   | 3                     | Direction.WEST    | 0                 | 3

    }

    private placeRobotInTable(int x = 0, int y = 0, Direction direction = Direction.NORTH){
        Robot robot = new Robot()
        robot.setCoordinates(new Coordinates(x, y, direction))

        robotMovementService.table.robot = robot
    }
}
