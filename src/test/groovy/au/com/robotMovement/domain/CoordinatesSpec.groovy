package au.com.robotMovement.domain

import au.com.robotMovement.enums.Direction
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author rnadeera
 */
class CoordinatesSpec extends Specification {

    @Unroll
    def "test getXCoordinateOnNextMove, should return new x #newXValue when current x #currentXValue and direction is #direction"(){
        given:
        Coordinates coordinates = new Coordinates(currentXValue, 0, direction)

        when:
        int newXCoordinate = coordinates.getXCoordinateOnNextMove()

        then:
        newXCoordinate == newXValue

        where:
        currentXValue | direction       | newXValue
        2             | Direction.NORTH | 2
        1             | Direction.SOUTH | 1
        3             | Direction.EAST  | 4
        2             | Direction.WEST  | 1
    }
    @Unroll
    def "test getYCoordinateOnNextMove, should return new y #newYValue when current y #currentYValue and direction is #direction"(){
        given:
        Coordinates coordinates = new Coordinates(0, currentYValue, direction)

        when:
        int newYCoordinate = coordinates.getYCoordinateOnNextMove()

        then:
        newYCoordinate == newYValue

        where:
        currentYValue | direction       | newYValue
        2             | Direction.NORTH | 3
        1             | Direction.SOUTH | 0
        3             | Direction.EAST  | 3
        2             | Direction.WEST  | 2
    }
}
