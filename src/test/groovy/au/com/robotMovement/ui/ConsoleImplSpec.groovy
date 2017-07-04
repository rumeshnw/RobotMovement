package au.com.robotMovement.ui

import au.com.robotMovement.config.ResourceFactory
import au.com.robotMovement.enums.Command
import au.com.robotMovement.enums.Direction
import au.com.robotMovement.service.RobotMovementService
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author rnadeera
 */
class ConsoleImplSpec extends Specification {

    ConsoleImpl console

    def setup(){
        console = ResourceFactory.console()
    }

    def "test getCommand, should throw an IllegalArgumentException when invalid command is entered by the user"(){
        when:
        console.getCommand("INVALID_COMMAND")

        then:
        def e       = thrown(IllegalArgumentException)
        e.message   == "Invalid command. Please try again with a valid command."
    }

    def "test getCommand, should return specific Command when valid command is entered by the user"(){
        when:
        Command command = console.getCommand("PLACE")

        then:
        notThrown(IllegalArgumentException)

        and:
        command == Command.PLACE
    }

    def "test getPlacementCoordinates, should return String array with coordinates and facinf direction for valid PLACE command"(){
        when:
        String[] coordinates = console.getPlacementCoordinates("PLACE 2,0,NORTH")

        then:
        coordinates[0] == "2"
        coordinates[1] == "0"
        coordinates[2] == "NORTH"
    }

    @Unroll
    def "test placeRobot, should throw an IllegalArgumentException when PLACE command is #placeCommand which is invalid"(){
        when:
        console.placeRobot(placeCommand)

        then:
        def e       = thrown(IllegalArgumentException)
        e.message   == "Format of the PLACE command is invalid. Valid command should be PLACE X,Y,F where X is X coordinate, Y is Y coordinate and F is Facing direction(NORTH,SOUTH,EAST,WEST)"

        where:
        _ | placeCommand
        _ | "INVALID_COMMAND"
        _ | "PLACE"
        _ | "PLACE1,2,F"
        _ | "PLACE -1,0,NORTH"
        _ | "PLACE 111,0,NORTH"
        _ | "PLACE 0,-2,NORTH"
        _ | "PLACE 0,212,NORTH"
        _ | "PLACE 0,2,INVALID_DIRECTION"
    }

    def "test placeRobot, should place the robot on the table when PLACE command is entered with valid coordinates"(){
        given:
        console.robotMovementService = Mock(RobotMovementService){
            1 * positionRobot(*_) >> { int xCoordinate, int yCoordinate, Direction direction -> return }
        }

        when:
        console.placeRobot("PLACE 0,1,NORTH")

        then:
        notThrown(IllegalArgumentException)
    }
}
