package au.com.robotMovement.domain

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author rnadeera
 */
class TableSpec extends Specification {

    def "test getRobotInstance, should return new Robot instance when robot is null on Table instance"(){
        given:
        Table table = Table.buildSquareTable(5)

        expect:
        !table.robot

        when:
        Robot robot  = table.getRobotInstance()

        then:
        robot
        table.robot

        robot == table.robot
    }

    @Unroll
    def "test isValidPosition, should return #validity when coordinatesX #coordinatesX and coordinatesY #coordinatesY"(){
        given:
        Table table = Table.buildSquareTable(5)

        when:
        boolean isValid = table.isValidPosition(coordinatesX, coordinatesY)

        then:
        isValid == validity

        where:
        coordinatesX    | coordinatesY  | validity
        1               | 4             | true
        5               | 0             | false
        4               | 5             | false
        -1              | 3             | false
        3               | -2            | false
        7               | 1             | false
        4               | 8             | false
    }
}
